package gitlet;
import com.sun.nio.sctp.SctpStandardSocketOptions;

import java.io.File;
import java.io.IOException;

import static gitlet.Utils.*;


/** Represents a gitlet repository.
 *  TODO: It's a good idea to give a description here of what else this Class
 *  does at a high level.
 *  .gitlet/ -- top level folder for all persistence meta data in gitlet
 *      -staging/  -- second level folder for staging area.
 *          -addStaged/ -- store for newly added files
 *          -rmStaged/  -- store for newly deleted files
 *      - commits/ -- second level folder for commit node informations
 *      - blobs/   -- second level folder for different version of commited files
 *      - refs/
 *          - heads/    --
 *          - remotes/  --
 *      - HEAD/    -- store branch name, default for master
 *
 *  @author TOMYUE
 */
public class Repository {
    /**
     * TODO: add instance variables here.
     *
     * List all instance variables of the Repository class here with a useful
     * comment above them describing what that variable represents and how that
     * variable is used. We've provided two examples for you.
     */

    /** The current working directory. */
    public static final File CWD = new File(System.getProperty("user.dir"));
    /** The .gitlet directory. */
    public static final File GITLET_DIR = join(CWD, ".gitlet");

    /* TODO: fill in the rest of this class. */
    /* The staging area folder "stagingArea".
    *  excluding two folder, one is staged for adding files, another is staged for removing files.
    *  The former is STAGED_ADD--"addStaged", the latter is STAGED_REMOVE--"removeStaged". */
    public static final File STAGING_AREA_DIR = join(GITLET_DIR, "staging");
    public static final File STAGED_ADD = join(STAGING_AREA_DIR, "addStaged");
    public static final File STAGED_REMOVE = join(STAGING_AREA_DIR, "rmStaged");

    /* commit folder to store meta data */
    public static final File COMMIT_DIR = join(GITLET_DIR, "commits");

    /* bolbs folder to store different versions */
    public static final  File BLOBS = join(GITLET_DIR, "blobs");


    /* setup repo */
    public static void setPersistence() throws IOException {
        // create .gitlet folder
        GITLET_DIR.mkdir();
        if(GITLET_DIR.exists()){
            System.out.println("Not in an initialized Gitlet directory.");
        }else {
            // create stagingArea folder
            STAGING_AREA_DIR.mkdir();
            // addStaged folder
            STAGED_ADD.mkdir();
            // removeStaged folder
            STAGED_REMOVE.mkdir();
            // create commitArea folder
            COMMIT_DIR.mkdir();
            // create bolbs folder
            BLOBS.mkdir();
        }
    }

    /* write commit info to the */
    public void writeCommitInfo(String text) {}

    /* init command */
    static void init() throws IOException{
        setPersistence();

    }
}