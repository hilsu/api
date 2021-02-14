package su.hil.api.chat.objects;

import java.util.UUID;

public class User {
    protected String type;

    // hil user
    protected long id;
    protected UUID gameId;
    protected String username;
    protected Rank rank;
    protected boolean isMe;

    // telegram user
    protected String firstName;
    protected String lastName;

    // hidden telegram user
    protected String name;

    public String getType() {
        return type;
    }

    public long getId() {
        return id;
    }

    public UUID getGameId() {
        return gameId;
    }

    public String getUsername() {
        return username;
    }

    public Rank getRank() {
        return rank;
    }

    public boolean isMe() {
        return isMe;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "type='" + type + '\'' +
                ", id=" + id +
                ", gameId=" + gameId +
                ", username='" + username + '\'' +
                ", rank=" + rank +
                ", isMe=" + isMe +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
