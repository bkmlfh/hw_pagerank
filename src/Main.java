import org.htmlparser.util.ParserException;

public class Main {

    /**
     * @param args
     * @throws ParserException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws ParserException,
            InterruptedException {
        MyParser pars = new MyParser("http://www.the-village.ru/");

        PageRank pr = new PageRank();
        pr.hyperlinkMatrix(pars.sm, pars.matrix);
        pr.writeFile(pr.calcPR());

        PageRank pr2 = new PageRank();
        pr2.hyperlinkMatrix(pars.sm, pars.matrix);
        pr2.writeFile(pr2.calcPRParallel());

        System.out.println(pr.timeConsumedMillis - pr.timeConsumedMillisParallel);


    }

}
