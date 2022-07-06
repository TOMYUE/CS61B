package gitlet;


import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date; // TODO: You'll likely use this in this class
import java.util.HashMap;
import java.util.List;

/** Represents a gitlet commit object.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *
 *  @author TOMYUE
 */
public class Commit {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Commit class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided one example for `message`.
     */

    /** The message of this Commit.
     *  Include commit message, timestamp, this commit's SHA1 hash value. */
    private String message;
    private Date datetime;
    private String curHash; //该文件当前commit的hash值
    private String parentHash; //该文件上次提交的hash值
    /* <fileName , SHA1> */
    private HashMap<String, String> blobs;

    /* TODO: fill in the rest of this class. */
    public Commit(String msg, HashMap<String, String> blobs, String parentHash) throws IOException {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.message = msg;
        this.blobs = blobs;
        this.parentHash = parentHash;
        this.curHash = calculateCurHash();
        // write new commit info--this is a String object to FILE
        SerializeUtils.writeStringToFile(gitMessageFormatter(), Repository.COMMIT_DIR + "/" + this.curHash.substring(0,3), true);
    }

    /** Git style commit message format generator. */
    public String gitMessageFormatter() {
        String firstLine  = "===\n";
        String secondLine = "Commit " + this.curHash + "\n";
        String thirdLine  = "Date:  " + this.datetime + "\n";
        String fourthLine = this.message + "\n";
        String fifthLine  = "\n";
        String commitMessage = firstLine + secondLine +
                thirdLine + fourthLine + fifthLine;
        return commitMessage;
    }

    /** Calculate this Commit's SHA-1 hash value via Utils.sha1.
     *  Using SerializeUtils to help convert Object to byteArray.
     * */
    public String calculateCurHash() {
        byte[] commitObj = SerializeUtils.toByteArray(this);
        return Utils.sha1(commitObj);
    }

    /** Get the commit hash value. */
    public String getHashValue(){
        return this.curHash;
    }

    /** Get the parent hash value. */
    public String getParentHashValue() {
        return this.parentHash;
    }

    /** Get the commit message. */
    public String getCommitMessage() {
        return this.message;
    }

    /** Get the current timestamp. */
    public Date getDatetime() {
        return this.datetime;
    }

    /** Get the Blobs*/
    public HashMap<String, String> getBlobs() {
        return this.blobs;
    }

}
