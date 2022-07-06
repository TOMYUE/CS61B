package gitlet;


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
    public Commit(String msg, HashMap<String, String> blobs, String parentHash) {
        LocalDateTime current = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.message = msg;
        this.blobs = blobs;
        this.parentHash = parentHash;
        this.curHash = calculateCurHash();
        // write new commit info--this is a String object to FILE

    }

    /** Calculate this Commit's SHA-1 hash value via Utils.sha1.
     * */
    public String calculateCurHash() {

    }












}
