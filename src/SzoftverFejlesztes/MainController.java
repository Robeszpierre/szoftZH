package SzoftverFejlesztes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


public class MainController {
    @FXML
    private TextArea commentTextArea;
    @FXML
    private DatePicker startDate;
    @FXML
    private DatePicker endDate;
    @FXML
    PieChart pieChart1;
    @FXML
    PieChart pieChart2;

    private HashMap<String, Integer> followers =new HashMap<>();
    private HashMap<String, Integer> interactions =new HashMap<>();
    private ArrayList<Facebook> facebooks=new ArrayList<>();

    @FXML
    public void initialize() throws FileNotFoundException {
        readFiles();
        for(Facebook f: facebooks){
            followers.put(f.getSource(), 0);
        }
        for(Facebook f: facebooks){
            int current= followers.get(f.getSource());
            followers.put(f.getSource(), current+Integer.parseInt(f.getFollowers()));
        }
        makePieChart();

        for(Facebook f: facebooks){
            interactions.put(f.getSource(), 0);
        }
        for(Facebook f: facebooks){
            int current2= interactions.get(f.getSource());
            interactions.put(f.getSource(), current2+Integer.parseInt(f.getInteractions()));
        }
        //interactions.forEach((k, v) -> System.out.println(v +" "+ k));
        makePieChart2();
    }

    private void makePieChart() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        followers.forEach((k, v) -> pieChartData.add(new PieChart.Data(k, v)));


        pieChart1.setData(pieChartData);
    }

    private void makePieChart2() {
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        interactions.forEach((k, v) -> pieChartData.add(new PieChart.Data(k, v)));


        pieChart2.setData(pieChartData);
    }


    public void readFiles() throws FileNotFoundException{

        String csvFile = "";
        String line = "";
        String cvsSplitBy=";";

        for(int i=2; i<6; i++) {
            csvFile="./src/SzoftverFejlesztes/Resource/Removed_FB_Pages_Posts_Engagement Metrics_"+i+".csv";
            readFromCsv(csvFile, cvsSplitBy);
        }

    }

    private void readFromCsv(String csvFile, String cvsSplitBy) {
        String line;
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            int i=0;
            while ((line = br.readLine()) != null) {

                if(i==0){ //skip the headers
                    i++;
                    continue;
                }
                String[] s = line.split(cvsSplitBy);

                try {
                    Facebook f = new Facebook(s[0], s[1], s[2], s[3], s[4], s[5], s[6], s[7], s[8], s[9]);
                    //System.out.println(f.getPostMessage());
                    facebooks.add(f);
                } catch (Exception e) {
                    //end of file
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void listComments(MouseEvent mouseEvent) {
        String text="";
        for(Facebook f: facebooks){
            LocalDate start=startDate.getValue();
            LocalDate check=LocalDate.parse(f.getDate());
            LocalDate end=endDate.getValue();

            if(check.isAfter(start) && check.isBefore(end)){
                text+="\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------\n" + f.getPostMessage();
            }
        }
        commentTextArea.setText(text);
    }


}
