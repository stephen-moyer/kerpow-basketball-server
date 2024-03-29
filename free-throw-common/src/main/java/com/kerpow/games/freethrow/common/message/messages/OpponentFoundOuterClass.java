// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OpponentFound.proto

package com.kerpow.games.freethrow.common.message.messages;

public final class OpponentFoundOuterClass {
  private OpponentFoundOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface OpponentFoundOrBuilder extends
      // @@protoc_insertion_point(interface_extends:com.kerpow.games.freethrow.common.OpponentFound)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated int32 opponents = 1;</code>
     */
    java.util.List<java.lang.Integer> getOpponentsList();
    /**
     * <code>repeated int32 opponents = 1;</code>
     */
    int getOpponentsCount();
    /**
     * <code>repeated int32 opponents = 1;</code>
     */
    int getOpponents(int index);
  }
  /**
   * Protobuf type {@code com.kerpow.games.freethrow.common.OpponentFound}
   */
  public static final class OpponentFound extends
      com.google.protobuf.GeneratedMessage implements
      // @@protoc_insertion_point(message_implements:com.kerpow.games.freethrow.common.OpponentFound)
      OpponentFoundOrBuilder {
    // Use OpponentFound.newBuilder() to construct.
    private OpponentFound(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private OpponentFound(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final OpponentFound defaultInstance;
    public static OpponentFound getDefaultInstance() {
      return defaultInstance;
    }

    public OpponentFound getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private OpponentFound(
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
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                opponents_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              opponents_.add(input.readInt32());
              break;
            }
            case 10: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001) && input.getBytesUntilLimit() > 0) {
                opponents_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000001;
              }
              while (input.getBytesUntilLimit() > 0) {
                opponents_.add(input.readInt32());
              }
              input.popLimit(limit);
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
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          opponents_ = java.util.Collections.unmodifiableList(opponents_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.internal_static_com_kerpow_games_freethrow_common_OpponentFound_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.internal_static_com_kerpow_games_freethrow_common_OpponentFound_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound.class, com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound.Builder.class);
    }

    public static com.google.protobuf.Parser<OpponentFound> PARSER =
        new com.google.protobuf.AbstractParser<OpponentFound>() {
      public OpponentFound parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new OpponentFound(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<OpponentFound> getParserForType() {
      return PARSER;
    }

    public static final int OPPONENTS_FIELD_NUMBER = 1;
    private java.util.List<java.lang.Integer> opponents_;
    /**
     * <code>repeated int32 opponents = 1;</code>
     */
    public java.util.List<java.lang.Integer>
        getOpponentsList() {
      return opponents_;
    }
    /**
     * <code>repeated int32 opponents = 1;</code>
     */
    public int getOpponentsCount() {
      return opponents_.size();
    }
    /**
     * <code>repeated int32 opponents = 1;</code>
     */
    public int getOpponents(int index) {
      return opponents_.get(index);
    }

    private void initFields() {
      opponents_ = java.util.Collections.emptyList();
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      for (int i = 0; i < opponents_.size(); i++) {
        output.writeInt32(1, opponents_.get(i));
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      {
        int dataSize = 0;
        for (int i = 0; i < opponents_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(opponents_.get(i));
        }
        size += dataSize;
        size += 1 * getOpponentsList().size();
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

    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound prototype) {
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
     * Protobuf type {@code com.kerpow.games.freethrow.common.OpponentFound}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:com.kerpow.games.freethrow.common.OpponentFound)
        com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFoundOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.internal_static_com_kerpow_games_freethrow_common_OpponentFound_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.internal_static_com_kerpow_games_freethrow_common_OpponentFound_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound.class, com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound.Builder.class);
      }

      // Construct using com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound.newBuilder()
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
        opponents_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.internal_static_com_kerpow_games_freethrow_common_OpponentFound_descriptor;
      }

      public com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound getDefaultInstanceForType() {
        return com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound.getDefaultInstance();
      }

      public com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound build() {
        com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound buildPartial() {
        com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound result = new com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound(this);
        int from_bitField0_ = bitField0_;
        if (((bitField0_ & 0x00000001) == 0x00000001)) {
          opponents_ = java.util.Collections.unmodifiableList(opponents_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.opponents_ = opponents_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound) {
          return mergeFrom((com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound other) {
        if (other == com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound.getDefaultInstance()) return this;
        if (!other.opponents_.isEmpty()) {
          if (opponents_.isEmpty()) {
            opponents_ = other.opponents_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureOpponentsIsMutable();
            opponents_.addAll(other.opponents_);
          }
          onChanged();
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (com.kerpow.games.freethrow.common.message.messages.OpponentFoundOuterClass.OpponentFound) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<java.lang.Integer> opponents_ = java.util.Collections.emptyList();
      private void ensureOpponentsIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          opponents_ = new java.util.ArrayList<java.lang.Integer>(opponents_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated int32 opponents = 1;</code>
       */
      public java.util.List<java.lang.Integer>
          getOpponentsList() {
        return java.util.Collections.unmodifiableList(opponents_);
      }
      /**
       * <code>repeated int32 opponents = 1;</code>
       */
      public int getOpponentsCount() {
        return opponents_.size();
      }
      /**
       * <code>repeated int32 opponents = 1;</code>
       */
      public int getOpponents(int index) {
        return opponents_.get(index);
      }
      /**
       * <code>repeated int32 opponents = 1;</code>
       */
      public Builder setOpponents(
          int index, int value) {
        ensureOpponentsIsMutable();
        opponents_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 opponents = 1;</code>
       */
      public Builder addOpponents(int value) {
        ensureOpponentsIsMutable();
        opponents_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 opponents = 1;</code>
       */
      public Builder addAllOpponents(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureOpponentsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, opponents_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 opponents = 1;</code>
       */
      public Builder clearOpponents() {
        opponents_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:com.kerpow.games.freethrow.common.OpponentFound)
    }

    static {
      defaultInstance = new OpponentFound(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:com.kerpow.games.freethrow.common.OpponentFound)
  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_com_kerpow_games_freethrow_common_OpponentFound_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_com_kerpow_games_freethrow_common_OpponentFound_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\023OpponentFound.proto\022!com.kerpow.games." +
      "freethrow.common\"\"\n\rOpponentFound\022\021\n\topp" +
      "onents\030\001 \003(\005B4\n2com.kerpow.games.freethr" +
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
    internal_static_com_kerpow_games_freethrow_common_OpponentFound_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_com_kerpow_games_freethrow_common_OpponentFound_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessage.FieldAccessorTable(
        internal_static_com_kerpow_games_freethrow_common_OpponentFound_descriptor,
        new java.lang.String[] { "Opponents", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
