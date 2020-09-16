package su.hil.api.chat.objects.messagereceived;

public class AttachmentMeta {
    protected String caption;
    protected String fileName;
    protected String mimeType;
    protected long fileSize;
    protected int width;
    protected int height;
    protected String performer;
    protected String title;
    protected int duration;

    public String getCaption() {
        return caption;
    }

    public String getFileName() {
        return fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPerformer() {
        return performer;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }
}
