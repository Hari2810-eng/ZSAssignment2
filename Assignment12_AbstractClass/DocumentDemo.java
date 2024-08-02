abstract class Document {
    protected String title;
    protected String author;

    public Document(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract void open();
    public abstract void save();
    public abstract void print();

    public String getDetails() {
        return "Title: " + title + "\nAuthor: " + author;
    }
}


class PDFDocument extends Document {

    public PDFDocument(String title, String author) {
        super(title, author);
    }

    @Override
    public void open() {
        System.out.println("Opening PDF document: " + title);
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document: " + title);
    }

    @Override
    public void print() {
        System.out.println("Printing PDF document: " + title);
    }
}

class TextDocument extends Document {

    public TextDocument(String title, String author) {
        super(title, author);
    }

    @Override
    public void open() {
        System.out.println("Opening Text document: " + title);
    }

    @Override
    public void save() {
        System.out.println("Saving Text document: " + title);
    }

    @Override
    public void print() {
        System.out.println("Printing Text document: " + title);
    }
}

class ImageDocument extends Document {

    public ImageDocument(String title, String author) {
        super(title, author);
    }

    @Override
    public void open() {
        System.out.println("Opening Image document: " + title);
    }

    @Override
    public void save() {
        System.out.println("Saving Image document: " + title);
    }

    @Override
    public void print() {
        System.out.println("Printing Image document: " + title);
    }
}


public class DocumentDemo {
    public static void main(String[] args) {
        Document pdfDoc = new PDFDocument("Java Programming", "Arun");
        Document textDoc = new TextDocument("Meeting Notes", "Arul");
        Document imageDoc = new ImageDocument("Vacation Photo", "Adhi");

        System.out.println(pdfDoc.getDetails());
        pdfDoc.open();
        pdfDoc.save();
        pdfDoc.print();

        System.out.println("\n" + textDoc.getDetails());
        textDoc.open();
        textDoc.save();
        textDoc.print();

        System.out.println("\n" + imageDoc.getDetails());
        imageDoc.open();
        imageDoc.save();
        imageDoc.print();
    }
}
