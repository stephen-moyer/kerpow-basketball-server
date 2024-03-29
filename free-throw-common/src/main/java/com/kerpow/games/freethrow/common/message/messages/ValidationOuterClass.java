// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: Validation.proto

package com.kerpow.games.freethrow.common.message.messages;

public final class ValidationOuterClass {
  private ValidationOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface ValidationOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.kerpow.games.freethrow.common.Validation)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>required int32 id = 1;</code>
     */
    boolean hasId();
    /**
     * <code>required int32 id = 1;</code>
     */
    int getId();

    /**
     * <code>required string key = 2;</code>
     */
    boolean hasKey();
    /**
     * <code>required string key = 2;</code>
     */
    java.lang.String getKey();
    /**
     * <code>required string key = 2;</code>
     */
    com.google.protobuf.ByteString
        getKeyBytes();
  }
  /**
   * Protobuf type {@code com.kerpow.games.freethrow.common.Validation}
   */
  public static final class Validation extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.kerpow.games.freethrow.common.Validation)
      ValidationOrBuilder {
    // Use Validation.newBuilder() to construct.
    private Validation(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private Validation(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final Validation defaultInstance;
    public static Validation getDefaultInstance() {
      return defaultInstance;
    }

    public Validation getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private Validation(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              id_ = input.readInt32();
              break;
            }
            case 18: {
              com.google.protobuf.ByteString bs = input.readBytes();
              bitField0_ |= 0x00000002;
              key_ = bs;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.internal_static_com_kerpow_games_freethrow_common_Validation_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.internal_static_com_kerpow_games_freethrow_common_Validation_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation.class, com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation.Builder.class);
    }

    public static com.google.protobuf.Parser<Validation> PARSER =
        new com.google.protobuf.AbstractParser<Validation>() {
      public Validation parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Validation(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<Validation> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>required int32 id = 1;</code>
     */
    public boolean hasId() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>required int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    public static final int KEY_FIELD_NUMBER = 2;
    private java.lang.Object key_;
    /**
     * <code>required string key = 2;</code>
     */
    public boolean hasKey() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>required string key = 2;</code>
     */
    public java.lang.String getKey() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        if (bs.isValidUtf8()) {
          key_ = s;
        }
        return s;
      }
    }
    /**
     * <code>required string key = 2;</code>
     */
    public com.google.protobuf.ByteString
        getKeyBytes() {
      java.lang.Object ref = key_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        key_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private void initFields() {
      id_ = 0;
      key_ = "";
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      if (!hasId()) {
        memoizedIsInitialized = 0;
        return false;
      }
      if (!hasKey()) {
        memoizedIsInitialized = 0;
        return false;
      }
      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeBytes(2, getKeyBytes());
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(2, getKeyBytes());
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code com.kerpow.games.freethrow.common.Validation}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.kerpow.games.freethrow.common.Validation)
        com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.ValidationOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.internal_static_com_kerpow_games_freethrow_common_Validation_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.internal_static_com_kerpow_games_freethrow_common_Validation_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation.class, com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation.Builder.class);
      }

      // Construct using com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        id_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        key_ = "";
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.internal_static_com_kerpow_games_freethrow_common_Validation_descriptor;
      }

      public com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation getDefaultInstanceForType() {
        return com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation.getDefaultInstance();
      }

      public com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation build() {
        com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation buildPartial() {
        com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation result = new com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.id_ = id_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.key_ = key_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation) {
          return mergeFrom((com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation other) {
        if (other == com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation.getDefaultInstance()) return this;
        if (other.hasId()) {
          setId(other.getId());
        }
        if (other.hasKey()) {
          bitField0_ |= 0x00000002;
          key_ = other.key_;
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        if (!hasId()) {
          
          return false;
        }
        if (!hasKey()) {
          
          return false;
        }
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.kerpow.games.freethrow.common.message.messages.ValidationOuterClass.Validation) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int id_ ;
      /**
       * <code>required int32 id = 1;</code>
       */
      public boolean hasId() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder setId(int value) {
        bitField0_ |= 0x00000001;
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required int32 id = 1;</code>
       */
      public Builder clearId() {
        bitField0_ = (bitField0_ & ~0x00000001);
        id_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object key_ = "";
      /**
       * <code>required string key = 2;</code>
       */
      public boolean hasKey() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>required string key = 2;</code>
       */
      public java.lang.String getKey() {
        java.lang.Object ref = key_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          if (bs.isValidUtf8()) {
            key_ = s;
          }
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>required string key = 2;</code>
       */
      public com.google.protobuf.ByteString
          getKeyBytes() {
        java.lang.Object ref = key_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          key_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>required string key = 2;</code>
       */
      public Builder setKey(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        key_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>required string key = 2;</code>
       */
      public Builder clearKey() {
        bitField0_ = (bitField0_ & ~0x00000002);
        key_ = getDefaultInstance().getKey();
        onChanged();
        return this;
      }
      /**
       * <code>required string key = 2;</code>
       */
      public Builder setKeyBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000002;
        key_ = value;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.kerpow.games.freethrow.common.Validation)
    }

    static {
      defaultInstance = new Validation(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.kerpow.games.freethrow.common.Validation)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_kerpow_games_freethrow_common_Validation_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_kerpow_games_freethrow_common_Validation_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\020Validation.proto\022!com.kerpow.games.fre" +
      "ethrow.common\"%\n\nValidation\022\n\n\002id\030\001 \002(\005\022" +
      "\013\n\003key\030\002 \002(\tB4\n2com.kerpow.games.freethr" +
      "ow.common.message.messages"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_com_kerpow_games_freethrow_common_Validation_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_kerpow_games_freethrow_common_Validation_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_kerpow_games_freethrow_common_Validation_descriptor,
        new java.lang.String[] { "Id", "Key", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
