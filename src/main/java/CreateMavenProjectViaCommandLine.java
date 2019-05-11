public class CreateMavenProjectViaCommandLine {
    public static void main(String[] args){
        System.out.println("To create a simple maven project via command line use below command: - ");
        System.out.println("mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false");

        System.out.println("To make this maven project compatiable with eclipse use below command: - ");

        System.out.println("Now we can import this project in eclipse as existing maven project");
    }
}
