public class Painting extends Art {
    String paintType;
    public Painting(String paintType,String title, String author,String description){
        super.title=title;
        super.author=author;
        super.description=description;
        this.paintType=paintType;
    }

    @Override
    public void viewArt() {
        System.out.println("this is painting art");
        System.out.println("title "+super.title);
        System.out.println("author "+super.author);
        System.out.println("description "+super.description);
        System.out.println("paintType "+paintType);
        System.out.println("*********************************************************");
    }
}
