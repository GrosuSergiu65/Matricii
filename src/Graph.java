// Adjacency Matrix representation in Java

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Graph {
    private int adjMatrix[][];
    private int numarulDeVarfuri;

    public Graph(int[][] adjMatrix, int numarulDeVarfuri) {
        this.adjMatrix = adjMatrix;
        this.numarulDeVarfuri = numarulDeVarfuri;
    }

    public void addEdge(int i, int j) {
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void neutralEdge(int i, int j) {
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public void negativeEdge(int i, int j) {
        adjMatrix[i][j] = -1;
        adjMatrix[j][i] = -1;
    }


//    public static void main(String[] args) {
//
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println("Alegeti graf în forma selectat de profesor");
//        System.out.println("Aveți următoarele opțiuni de selectare:");
//        System.out.println("1 = Lista de adiacenta");
//        System.out.println("2 = Matricea de adiacenta");
//        System.out.println("3 = Matricea de incidenta");
//        System.out.println("0 = Finisare execuție");
//        String chosenMethod = scan.nextLine();
//
//
//        switch(chosenMethod) {
//            case "1":
//                System.out.println("Cate varfuri sunt prezente :");
//                listDeAdiacente( scan.nextInt());
//                break;
//            case "2":
//                for(int i =0; i < 5; i++) {
//                    int[][] matrix = new int[4][4];
//                    Graph graph = new Graph(matrix, 5);
//
//                    System.out.println("Adaugati valoarea pentru Entitate (a)");
//                    int a = scan.nextInt();
//                    System.out.println("Adăugați valoarea pentru alăturatul Entității (b)");
//                    int b = scan.nextInt();
//
//                }
//
//
//                break;
//            case "3":
//                // code block
//                break;
//            default:
//                System.out.println("Program finisat");
//        }
//
//
//
//    }


    public static void main(String[] args) {

        MatriceaDeIncidenta(MatriceaDeAdiacente(listDeAdiacente(5)));
    }
private static Map<Integer, int[]> listDeAdiacente(int numarulDeVarfuri){
    Map<Integer, int[]> listaMatricii = new HashMap<>();
    int[] arrayCuNoduri = new int[numarulDeVarfuri];

    Scanner scan = new Scanner(System.in);


   for(int i = 0; i <numarulDeVarfuri; i++) {
       System.out.println("Introdu lista de arce pentru varful :" + (i+1));
       System.out.println("adauga 0 daca nu mai sunt arce");
       for (int j = 0; j <= numarulDeVarfuri; j++) {
           int nod = scan.nextInt();
           if (nod == 0) {
               listaMatricii.put(i, arrayCuNoduri);
               arrayCuNoduri = new int[numarulDeVarfuri];
               break;
           }
           arrayCuNoduri[j] = nod;
       }
   }
        return listaMatricii;
}

private static Map<Integer, int[]> MatriceaDeAdiacente(Map<Integer, int[]>  listMap){
        int numarulDeVarfuri = listMap.size();
        int[][] matricea = new int[numarulDeVarfuri][numarulDeVarfuri];

        for(int i =0; i<numarulDeVarfuri; i++){
            int[] liniaDinMatricie = listMap.get(i);
            for(int j =0; j<numarulDeVarfuri; j++){
                if(liniaDinMatricie[j]>0)matricea[i][liniaDinMatricie[j]-1]=1;

            }
            System.out.println(Arrays.toString(matricea[i]));
        }

        return listMap;
}

    private static Map<Integer, int[]> MatriceaDeIncidenta(Map<Integer, int[]>  listMap){
        int numarulDeVarfuri = listMap.size();
        AtomicInteger numarulDeNoduri = new AtomicInteger();
        System.out.println();
        System.out.println("_--------------_");
        System.out.println();
        listMap.forEach(
                (key, value) -> {
                    for (int i = 0; i < value.length; i++) {
                        if (value[i] != 0) {
                            numarulDeNoduri.getAndIncrement();
                        }
                    }
                }
        );

        int[][] matricea = new int[numarulDeNoduri.get()][numarulDeVarfuri];
        int index = 0;
        for(int i =0; i<numarulDeVarfuri; i++){

            int[] liniaDinMatricie = listMap.get(i);
            for(int j =0; j<numarulDeVarfuri; j++){
                if(liniaDinMatricie[j]>0){
                    int temp = liniaDinMatricie[j];
                    matricea[index][i]=-1;
                    matricea[index][temp-1]=1;
                    index++;
                }
            }
        }
        for(int[] x: matricea)
            System.out.println(Arrays.toString(x));
        return listMap;
    }

}