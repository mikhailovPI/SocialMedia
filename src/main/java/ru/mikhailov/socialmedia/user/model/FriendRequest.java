package ru.mikhailov.socialmedia.user.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = FriendRequest.TABLE_REQUEST, schema = FriendRequest.SCHEMA_TABLE)
public class FriendRequest {

    public static final String SCHEMA_TABLE = "public";
    public static final String TABLE_REQUEST = "friends_request";
    public static final String REQUEST_ID = "request_id";
    //public static final String SENDER = "sender_id";
    //public static final String RECEIVER = "receiver_id";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = REQUEST_ID)
    Long id;

    @ManyToOne
    User sender;

    @ManyToOne
    User receiver;
}
