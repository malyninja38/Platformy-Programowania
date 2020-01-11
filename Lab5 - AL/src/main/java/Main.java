import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.*;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.SimpleFSDirectory;


public class Main {

    private static void load (IndexWriter indexWriter) {

        try (ItemProvider item_prov = new ItemProvider("items.xml")) {             // XML z którego pobieramy dane

            while (item_prov.hasNext()) {
                Item item = item_prov.next();
                addDoc(indexWriter, item);                                                  // Dodajemy do niego wszystko po kolei
            }

        } catch (Exception ex) { ex.printStackTrace(); }
    }

    private static void addDoc(IndexWriter w, Item item) throws IOException {

        Document dokument = new Document();
        dokument.add(new StringField("id", String.valueOf(item.getId()), Field.Store.YES));
        dokument.add(new TextField("price", String.valueOf(item.getPrice()), Field.Store.YES));
        dokument.add(new FloatPoint("price", item.getPrice()));                                           // Żeby w 2e móc porównywać ze sobą wartości - liczbowa wartość TextField "price"
        dokument.add(new TextField("name", item.getName(), Field.Store.YES));
        dokument.add(new TextField("category", item.getCategory() != null ? item.getCategory() : "None", Field.Store.YES));
        dokument.add(new TextField("description", item.getDescription(), Field.Store.YES));
        w.addDocument(dokument);
    }

    private static void sort (ScoreDoc[] tab, IndexSearcher searcher){

        for(int j = 0; j < tab.length - 1; j++) {
            for (int i = 0; i < tab.length - 1; i++) {
                try {

                    float firstVal = Float.parseFloat(searcher.doc(tab[i].doc).get("price"));
                    float secondVal = Float.parseFloat(searcher.doc(tab[i + 1].doc).get("price"));

                    if (firstVal > secondVal) {
                        ScoreDoc tempDoc = tab[i + 1];
                        tab[i + 1] = tab[i];
                        tab[i] = tempDoc;
                    }

                } catch (Throwable ignored) { }
            }
        }
    }

    private static void read(Query q, Directory index) throws IOException {      // Do wypisywania na ekranie tego, co spełnia dane wyrażenie

        int hitsPerPage = 50;                                                    // max liczba wyników
        IndexReader reader = DirectoryReader.open(index);                        // Reader - do odczytywania danych
        IndexSearcher searcher = new IndexSearcher(reader);                      // Searcher - do przeszukiwania danych
        TopDocs docs = searcher.search(q, hitsPerPage);
        ScoreDoc[] hits = docs.scoreDocs;

        sort(hits, searcher);                                                    // sortowanie

        System.out.println("Znaleziono " + hits.length + " trafień");

        for (int i = 0; i < hits.length; ++i) {                                 // Wypisywanie po kolei "trafień"

            int docId = hits[i].doc;
            Document d = searcher.doc(docId);

            System.out.println();
            System.out.println("ID: " + d.get("id"));
            System.out.println("Cena: " + d.get("price"));
            System.out.println("Nazwa: " + d.get("name"));
            System.out.println("Kategoria: " + d.get("category"));
        }
    }

    public static void zad1(){

        try {

            StandardAnalyzer analyzer = new StandardAnalyzer();
            Directory index = new SimpleFSDirectory(Path.of("index"));                                                                                         // Tworzy "folder", z którego potem pobieramy dane

            // to używamy tylko raz, inaczej się duplikuje //

            //IndexWriterConfig config = new IndexWriterConfig(analyzer);
            //IndexWriter w = new IndexWriter(index, config);
            //load(w);                                                                                                                                               // Ładujemy dane do tego folderu z XMLa
            //w.close();

            System.out.println();
            System.out.println("Utworzono index");

        } catch (Exception e) { System.out.println(e.getMessage()); }
    }

    private static void zad2() throws IOException, ParseException {

        StandardAnalyzer analyzer = new StandardAnalyzer();
        Directory index = new SimpleFSDirectory(Path.of("index"));                                                                                               // Zadeklarowanie, że będziemy korzystać z indexu

        System.out.println();
        System.out.print("Podpunkt a: ");
        Query query_a = new QueryParser("name", analyzer).parse("Dekielek AND NOT Minolta");                                                                // W nazwie "Dekielek", ale nie "Minolta"
        read(query_a, index);
        System.out.println();

        System.out.println();
        System.out.print("Podpunkt b: ");
        Query query_b1 = new QueryParser("name", analyzer).parse("Dekielek");                                                                               // W nazwie "Dekielek"
        Query query_b2 = new QueryParser("description", analyzer).parse("tył");                                                                             // W nazwie "tył" - "na tył" wyszukuje też wszystko, co ma "na"
        BooleanQuery query_b = new BooleanQuery.Builder().add(query_b1, BooleanClause.Occur.MUST).add(query_b2, BooleanClause.Occur.MUST).build();                    // Łączymy dwa poprzednie warunki w jeden - oba muszą być spełnione
        read(query_b, index);
        System.out.println();

        System.out.println();
        System.out.print("Podpunkt c: ");
        Query query_c = new QueryParser("category", analyzer).parse("Dek*");                                                                                // Wszystko, co zaczyna się od "Dek..."
        read(query_c, index);
        System.out.println();

        System.out.println();
        System.out.print("Podpunkt d: ");
        Query query_d = new FuzzyQuery(new Term("name", "optyka"), 2);                                                                           // Wszystko, co ma w tytule "optyka" lub słowo różniące się max 2 literami
        read(query_d, index);
        System.out.println();

        System.out.println();
        System.out.print("Podpunkt e: ");
        Query query_e = FloatPoint.newRangeQuery("price", Float.parseFloat("5.0"), Float.parseFloat("10.0"));                                           // Zwraca to, co ma cenę od 5 do 30 + posortowane rosnąco, String jest rzutowany na Float i dzięki temu możemy wygenerować zakres
        read(query_e, index);
        System.out.println();

    }


    public static void main(String[] args) throws IOException, ParseException {
        //zad1();
        zad2();
    }

}
