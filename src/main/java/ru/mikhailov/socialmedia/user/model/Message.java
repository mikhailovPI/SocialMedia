package ru.mikhailov.socialmedia.user.model;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = Message.TABLE_USERS, schema = Message.SCHEMA_TABLE)
public class Message {

    public static final String SCHEMA_TABLE = "public";
    public static final String TABLE_USERS = "message";
    public static final String MESSAGE_ID = "message_id";
    public static final String SENDER = "sender_id";
    public static final String RECEIVER = "receiver_id";
    public static final String MESSAGE_TEXT = "text";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = MESSAGE_ID)
    Long id;

    @ManyToOne
    User sender;

    @ManyToOne
    User receiver;

    @Column(name = MESSAGE_TEXT)
    String content;
}


