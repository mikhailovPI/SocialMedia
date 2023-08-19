package ru.mikhailov.socialmedia.user.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = User.TABLE_USERS, schema = User.SCHEMA_TABLE)
public class User {

    public static final String SCHEMA_TABLE = "public";
    public static final String TABLE_USERS = "users";
    public static final String TABLE_USERS_ROLES = "users_roles";
    public static final String TABLE_USERS_FRIENDS = "friends";
    public static final String TABLE_MESSAGE_SENDER = "sender";
    public static final String TABLE_MESSAGE_RECEIVER = "receiver";
    public static final String TABLE_REQUEST_SENDER = "sender";
    public static final String TABLE_REQUEST_RECEIVER = "receiver";
    public static final String USERS_ID = "user_id";
    public static final String USERS_NAME = "user_name";
    public static final String USERS_PASSWORD = "user_password";
    public static final String USERS_EMAIL = "email";
    public static final String ROLE_ID = "role_id";
    public static final String FRIENDS = "friends";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = USERS_ID)
    Long id;

    @Column(name = USERS_NAME)
    String name;

    @Column(name = USERS_PASSWORD)
    String password;

    @Column(name = USERS_EMAIL)
    String email;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = TABLE_USERS_ROLES,
            joinColumns = @JoinColumn(name = USERS_ID),
            inverseJoinColumns = @JoinColumn(name = ROLE_ID))
    Set<Role> userRole = new HashSet<>();

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = TABLE_USERS_FRIENDS,
            joinColumns = @JoinColumn(name = USERS_ID),
            inverseJoinColumns = @JoinColumn(name = USERS_ID))
    Set<User> friends = new HashSet<>();

    @OneToMany(mappedBy = TABLE_REQUEST_SENDER)
    private List<FriendRequest> sentRequests;

    @OneToMany(mappedBy = TABLE_REQUEST_RECEIVER)
    private List<FriendRequest> receivedRequests;

    @OneToMany(mappedBy = TABLE_MESSAGE_SENDER)
    private List<Message> sentMessages;

    @OneToMany(mappedBy = TABLE_MESSAGE_RECEIVER)
    private List<Message> receivedMessages;
}
