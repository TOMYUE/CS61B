package capers;

import java.io.File;
import java.io.IOException;

/** A repository for Capers 
 * @author TOMYUE
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab6 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("."));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = Utils.join("CWD",".capers"); // TODO Hint: look at the `join`
                                            //      function in Utils

    /** create a new file to store story text. */
    static final File STORY_FOLDER = Utils.join(".capers","story");

    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        // TODO
        CAPERS_FOLDER.mkdir();
        Dog.DOG_FOLDER.mkdir();
        try{
            STORY_FOLDER.createNewFile();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        // TODO
        Utils.writeContents(STORY_FOLDER, Utils.readContentsAsString(STORY_FOLDER) + text + "\n");
        System.out.println(Utils.readContentsAsString(STORY_FOLDER));
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        // TODO
        Dog d = new Dog(name, breed, age);
        d.saveDog();
        System.out.println(d.toString());
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        // TODO
        Dog d = Dog.fromFile(name);
        d.haveBirthday();
        d.saveDog();
    }
}
