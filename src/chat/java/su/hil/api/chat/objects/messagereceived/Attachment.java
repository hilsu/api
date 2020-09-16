package su.hil.api.chat.objects.messagereceived;

public class Attachment {
    protected long id;
    protected Kind kind;
    protected long primaryId;
    protected String downloadToken;
    protected AttachmentMeta meta;

    public long getId() {
        return id;
    }

    public Kind getKind() {
        return kind;
    }

    public long getPrimaryId() {
        return primaryId;
    }

    public String getDownloadToken() {
        return downloadToken;
    }

    public AttachmentMeta getMeta() {
        return meta;
    }
}
