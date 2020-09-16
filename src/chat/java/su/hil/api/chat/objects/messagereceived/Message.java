package su.hil.api.chat.objects.messagereceived;

import su.hil.api.chat.objects.User;

public class Message {
    protected long id;
    protected long telegramId;
    protected User sender;
    protected long replyTo;
    protected Message replyToMessage;
    protected String text;
    protected User forwardedFrom;
    protected Attachment[] attachments;
    protected double createdAt;
    protected double editedAt;
    protected boolean isDeleted;

    public long getId() {
        return id;
    }

    public long getTelegramId() {
        return telegramId;
    }

    public User getSender() {
        return sender;
    }

    public long getReplyTo() {
        return replyTo;
    }

    public Message getReplyToMessage() {
        return replyToMessage;
    }

    public String getText() {
        return text;
    }

    public User getForwardedFrom() {
        return forwardedFrom;
    }

    public Attachment[] getAttachments() {
        return attachments;
    }

    public double getCreatedAt() {
        return createdAt;
    }

    public double getEditedAt() {
        return editedAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
