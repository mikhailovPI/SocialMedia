package ru.mikhailov.socialmedia.user.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = User.TABLE_USERS, schema = User.SCHEMA_TABLE)
public class User {

    public static final String SCHEMA_TABLE = "public";
    public static final String TABLE_USERS = "users";
    public static final String TABLE_USERS_ROLES = "users_roles";
    public static final String TABLE_USERS_FRIENDS = "friends";
    public static final String TABLE_USERS_SUBSCRIBER = "subscribers";
    public static final String TABLE_MESSAGE_SENDER = "sender";
    public static final String TABLE_MESSAGE_RECEIVER = "receiver";
    public static final String TABLE_REQUEST_SENDER = "sender";
    public static final String TABLE_REQUEST_RECEIVER = "receiver";
    public static final String USERS_ID = "user_id";
    public static final String USERS_NAME = "user_name";
    public static final String USERS_PASSWORD = "user_password";
    public static final String USERS_EMAIL = "email";
    public static final String ROLE_ID = "role_id";

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

    @ManyToMany
    Set<User> friends = new HashSet<>();

    @ManyToMany
    Set<User> subscribers = new HashSet<>(); //подписчики

    @OneToMany(mappedBy = TABLE_REQUEST_SENDER)
    List<FriendRequest> sentRequests = new ArrayList<>(); //отправленные запросы в друзья

    @OneToMany(mappedBy = TABLE_REQUEST_RECEIVER)
    List<FriendRequest> receivedRequests = new ArrayList<>(); //полученные запросы на добавление в друзья

    @OneToMany(mappedBy = TABLE_MESSAGE_SENDER)
    List<Message> sentMessages = new ArrayList<>();

    @OneToMany(mappedBy = TABLE_MESSAGE_RECEIVER)
    List<Message> receivedMessages = new ArrayList<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o)
                .getHibernateLazyInitializer()
                .getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this)
                .getHibernateLazyInitializer()
                .getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        User user = (User) o;
        return getId() != null && Objects.equals(getId(), user.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this)
                .getHibernateLazyInitializer()
                .getPersistentClass()
                .hashCode() : getClass()
                .hashCode();
    }
}
