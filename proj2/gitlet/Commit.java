package gitlet;


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
    private String curHash;
    private String parentHast;

    /* <fileName , SHA1> */
    private HashMap<String, String> blobs;

    /* TODO: fill in the rest of this class. */

}
