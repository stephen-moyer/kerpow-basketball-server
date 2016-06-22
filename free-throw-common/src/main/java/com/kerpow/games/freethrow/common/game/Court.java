package com.kerpow.games.freethrow.common.game;

import org.jbox2d.callbacks.ContactFilter;
import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.collision.shapes.CircleShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.Vec2;
import org.jbox2d.dynamics.*;
import org.jbox2d.dynamics.contacts.Contact;
import org.jbox2d.dynamics.joints.DistanceJointDef;
import org.jbox2d.dynamics.joints.RevoluteJointDef;

import java.util.ArrayList;

/**
 * Created by Steveadoo on 6/22/2016.
 */
public class Court {


    public static final float TIME_STEP = 1 / 60f;
    private static final int VELOCITY_ITERATIONS = 6;
    private static final int POSITION_ITERATIONS = 3;
    public static final float WORLD_WIDTH = 47f;
    private static final long BALL_TIME = 10000;
    private static final float BALL_SIZE = 1.7f;

    private final CourtCallbacks listener;

    private World world;
    private BodyDef ballBodyDef;
    private CircleShape ballShape;
    private FixtureDef ballFixtureDef;

    private Body sensorBody;
    private Body groundBody;

    private float netCenterX;
    private float netRadius;

    private Body shootingBody;

    public Court(CourtCallbacks listener) {
        this.listener = listener;
    }

    public void init() {
        this.world = new World(new Vec2(0, -10));
        buildWorld();
    }

    private void buildWorld() {
        world.setContactFilter(new ContactFilter() {
            @Override
            public boolean shouldCollide(Fixture fixtureA, Fixture fixtureB) {
                if (fixtureA.getBody().getUserData() instanceof BallData && fixtureB.getBody().getUserData() instanceof BallData) {
                    BallData ballDataA = (BallData) fixtureA.getBody().getUserData();
                    BallData ballDataB = (BallData) fixtureB.getBody().getUserData();
                    return ballDataA.owner == ballDataB.owner;
                }
                return true;
            }
        });
        //O.O
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                if (contact.getFixtureA().getBody() == groundBody || contact.getFixtureB().getBody() == groundBody) {
                    Fixture ballFixture = contact.getFixtureA().getBody() == groundBody ? contact.getFixtureB() : contact.getFixtureA();
                    Body other = ballFixture.getBody();
                    if (other.getUserData() != null && other.getUserData() instanceof BallData) {
                        BallData ballData = (BallData) other.getUserData();
                        if (!ballData.scored) {
                            listener.missed(ballData.owner);
                        }
                    }
                }
            }

            @Override
            public void endContact(Contact contact) {
                if (contact.getFixtureA().getBody() == sensorBody || contact.getFixtureB().getBody() == sensorBody) {
                    Fixture sensorFixture = contact.getFixtureA().getBody() == sensorBody ? contact.getFixtureA() : contact.getFixtureB();
                    Fixture ballFixture = contact.getFixtureA().getBody() == sensorBody ? contact.getFixtureB() : contact.getFixtureA();
                    Body sensor = sensorFixture.getBody();
                    Body other = ballFixture.getBody();
                    Vec2 sensorPos = sensor.getPosition();
                    Vec2 otherPos = other.getPosition();
                    if (other.getUserData() != null && other.getUserData() instanceof BallData) {
                        BallData ballData = (BallData) other.getUserData();
                        if (!ballData.scored && otherPos.x > netCenterX - netRadius && otherPos.x < netCenterX + netRadius && otherPos.y <= sensorPos.y) {
                            ballData.scored = true;
                            listener.scored(ballData.owner);
                        }
                    }
                }
            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });
        BodyDef groundDef = new BodyDef();
        groundDef.position.set(WORLD_WIDTH / 2f, 10f);
        groundBody = world.createBody(groundDef);
        PolygonShape groundShape = new PolygonShape();
        groundShape.setAsBox(WORLD_WIDTH / 2f, .5f);
        groundBody.createFixture(groundShape, 0.0f);

        ballBodyDef = new BodyDef();
        ballBodyDef.position.set(WORLD_WIDTH * .15f, 16f);
        ballBodyDef.type = BodyType.DYNAMIC;
        ballShape = new CircleShape();
        ballShape.setRadius(BALL_SIZE / 2f);
        ballFixtureDef = new FixtureDef();
        ballFixtureDef.shape = ballShape;
        ballFixtureDef.density = .75f;
        ballFixtureDef.friction = 0.8f;
        ballFixtureDef.restitution = 0.5f;

        buildBasketBallNet();
    }

    private void buildBasketBallNet() {
        float backboardX = WORLD_WIDTH - 7f;
        float backboardY = 29f;
        BodyDef backboardDef = new BodyDef();
        backboardDef.position.set(backboardX, backboardY);
        Body backboardBody = world.createBody(backboardDef);
        //backboardBody.setUserData(new Rectangle());
        PolygonShape backboardShape = new PolygonShape();
        backboardShape.setAsBox(.25f, 3.75f);
        backboardBody.createFixture(backboardShape, 0.0f);

        netRadius = 0.2426f * 3.95f + .5f;
        netCenterX = backboardX - (netRadius * 1.775f);
        float netTopY = backboardY - 3f;

        CircleShape rimShape = new CircleShape();
        rimShape.setRadius(.025f);

        BodyDef leftRimDef = new BodyDef();
        leftRimDef.position.set(netCenterX - netRadius, netTopY);
        Body leftRimBody = world.createBody(leftRimDef);
        //leftRimBody.setUserData(new Rectangle());
        leftRimBody.createFixture(rimShape, 0.0f);

        BodyDef rightRimDef = new BodyDef();
        rightRimDef.position.set(netCenterX + netRadius, netTopY);
        Body rightRimBody = world.createBody(rightRimDef);
        //rightRimBody.setUserData(new Rectangle());
        rightRimBody.createFixture(rimShape, 0.0f);

        Body[] left = createNet(netCenterX - netRadius, netTopY, leftRimBody);
        Body[] right = createNet(netCenterX + netRadius, netTopY, rightRimBody);

        float sizeIncrease = .25f;
        float height = .1f;
        for (int i = 0; i < left.length; i++) {
            float newY = netTopY - (i * sizeIncrease) - height;
            DistanceJointDef defJoint = new DistanceJointDef();
            defJoint.length = netRadius - (i * .1f);
            defJoint.dampingRatio = 2f;
            defJoint.initialize(left[i], right[i], new Vec2(netCenterX - netRadius, newY), new Vec2(netCenterX + netRadius, newY));
            world.createJoint(defJoint);
        }

        BodyDef sensorDef = new BodyDef();
        sensorDef.position.set(netCenterX, netTopY - .25f);
        sensorBody = world.createBody(sensorDef);
        sensorBody.createFixture(rimShape, 0.0f).setSensor(true);

    }

    private Body[] createNet(float x, float y, Body body) {
        Body firstBody = null;
        Body lastBody = null;
        float sizeIncrease = .25f;
        float height = .1f;
        Body[] bodies = new Body[5];
        for (int i = 0; i < bodies.length; i++) {
            float newX = x;
            float newY = y - (i * sizeIncrease) - height;
            BodyDef netDef = new BodyDef();
            netDef.type = BodyType.DYNAMIC;
            netDef.position.set(newX, newY);

            PolygonShape netShape = new PolygonShape();
            netShape.setAsBox(.025f, height);

            FixtureDef netFixtureDef = new FixtureDef();
            netFixtureDef.shape = netShape;
            netFixtureDef.density = 25f;
            netFixtureDef.friction = 0.4f;
            netFixtureDef.restitution = 0f;
            Body newBody = world.createBody(netDef);
            newBody.createFixture(netFixtureDef);
            if (firstBody == null) {
                firstBody = newBody;
            }
            if (lastBody != null) {
                RevoluteJointDef jointDef = new RevoluteJointDef();
                jointDef.initialize(newBody, lastBody, new Vec2(newX, newY + height));
                //jointDef.lowerAngle = (float) Math.toRadians(-5);
                //jointDef.upperAngle = (float) Math.toRadians(5);
                //jointDef.enableLimit = true;
                world.createJoint(jointDef);
            }
            bodies[i] = newBody;
            lastBody = newBody;
        }
        RevoluteJointDef jointDef = new RevoluteJointDef();
        jointDef.initialize(body, firstBody, new Vec2(x, y));
        jointDef.enableLimit = true;
        jointDef.lowerAngle = (float) Math.toRadians(-15);
        jointDef.upperAngle = (float) Math.toRadians(15);
        jointDef.enableLimit = true;
        jointDef.maxMotorTorque = 5f;
        jointDef.motorSpeed = 0f;
        jointDef.enableMotor = true;
        world.createJoint(jointDef);
        return bodies;
    }


    public void process(float delta) {
        doPhysicsStep(delta);
        if (listener != null && listener.shouldDraw()) {
            drawBalls();
        }
    }

    ArrayList<Body> removedBodies = new ArrayList<>();
    private void drawBalls() {
        for (Body body = world.getBodyList(); body != null; body = body.getNext())
        {
            if (body.getUserData() instanceof BallData) {
                BallData ballData = (BallData) body.getUserData();
                if (body.getPosition().y < 10f || System.currentTimeMillis() - ballData.time > BALL_TIME) {
                    removedBodies.add(body);
                    continue;
                }
                listener.drawBall(body.getPosition().x, body.getPosition().y, body.getAngle(), BALL_SIZE);
            }
        }
        for(Body remBody : removedBodies) {
            world.destroyBody(remBody);
        }
        removedBodies.clear();
    }

    float optimumForce = 1175f;
    float overShotMin = optimumForce + 2.5f;
    float overShotMax = optimumForce + 30f;
    float underShotMin = optimumForce - 30f;
    float underShotMax = optimumForce - 2.5f;

    public void shoot(long owner, float ballY, float ballVelY, float powerX, float powerY) {
        BodyDef ballBodyDef = new BodyDef();
        ballBodyDef.position.set(WORLD_WIDTH * .15f, ballY);
        ballBodyDef.type = BodyType.DYNAMIC;
        Body body = world.createBody(ballBodyDef);
        body.setLinearVelocity(new Vec2(0, ballVelY));
        body.setUserData(new BallData(owner));
        body.createFixture(ballFixtureDef);
        shoot(body, powerX, powerY);
    }

    public void shoot(long owner, float powerX, float powerY) {
        if (shootingBody == null)
            return;
        shoot(shootingBody, powerX, powerY);
        shootingBody = null;
    }

    private void shoot(Body body, float pX, float pY) {
        float powerX = pX;
        float powerY = pY;
        powerX *= 150;
        powerY *= 150;
        body.applyAngularImpulse((float) Math.toRadians(200));
        float force = powerX;
        System.out.println("Intial force: " + force);
        float avgAmt = .5f;
        float avgAdjusted = Math.abs((1.0f - Math.abs(optimumForce - force) / optimumForce) / avgAmt);
        System.out.println(avgAdjusted);
        force = ((optimumForce * avgAdjusted) + force) / (avgAdjusted + 1);
        System.out.println("Before overshot Force: " + force);
        if (force >= overShotMin && force <= overShotMax) {
            force = optimumForce;
        }
        if (force >= underShotMin && force <= underShotMax) {
            force = optimumForce;
        }
        System.out.println("After overshot Force: " + force);
        body.applyForceToCenter(new Vec2(force, powerY));
        if (body == shootingBody)
            listener.shot(pX, pY, body.getLinearVelocity().y, body.getPosition().y);
    }

    public void startShot(int id) {
        Body body = world.createBody(ballBodyDef);
        body.setUserData(new BallData(id));
        body.createFixture(ballFixtureDef);
        shootingBody = body;
        body.applyForceToCenter(new Vec2(0, 1250f));
    }

    private float accumulator = 0;

    private void doPhysicsStep(float deltaTime) {
        // fixed time step
        // max frame time to avoid spiral of death (on slow devices)
        float frameTime = Math.min(deltaTime, 0.25f);
        accumulator += frameTime;
        while (accumulator >= TIME_STEP) {
            world.step(TIME_STEP, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
            accumulator -= TIME_STEP;
        }
    }

    public void dispose() {
    }

    public interface CourtCallbacks {

        void scored(long owner);

        void missed(long owner);

        void shot(float powerX, float powerY, float velY, float posY);

        void drawBall(float x, float y, float angle, float size);

        boolean shouldDraw();
    }

    public class BallData {

        private final long owner;
        private final long time;

        public boolean scored;

        public BallData(long owner) {
            this.owner = owner;
            this.time = System.currentTimeMillis();
        }

    }
}
