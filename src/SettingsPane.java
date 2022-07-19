import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

// ( Settings ) يمثل الحاوية التي سنظهرها عند النقر على زر ضبط اللعبة SettingsPane الكلاس 
public class SettingsPane extends Pane {

    // هنا قمنا بإنشاء جميع الأشياء التي سنضعها في الحاوية
    Label labelForBoards = new Label("Game Board");
    Label labelForFontSizes = new Label("Font Size");
    ComboBox boardsComboBox = new ComboBox();
    ComboBox fontSizesComboBox = new ComboBox();
    Button reset = new Button("Reset Default Settings");
    Button back = new Button("Back");

    // هذا كونستركور الكلاس
    public SettingsPane() {

        // fontSizesComboBox و boardsComboBox هنا قمنا بوضع الخيارات التي يمكن للمستخدم اختيارها في الكائنين
        boardsComboBox.getItems().addAll("Board 1", "Board 2", "Board 3", "Board 4");
        fontSizesComboBox.getItems().addAll("Small", "Medium", "Large");

        // SettingsPane هنا قمنا بتحديد حجم كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        labelForBoards.setPrefSize(100, 30);
        boardsComboBox.setPrefSize(120, 30);
        labelForFontSizes.setPrefSize(100, 30);
        fontSizesComboBox.setPrefSize(120, 30);
        reset.setPrefSize(240, 40);
        back.setPrefSize(240, 40);

        // SettingsPane هنا قمنا بتحديد موقع كل شيء سنضيفه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس
        labelForBoards.setTranslateX(80);
        labelForBoards.setTranslateY(130);
        boardsComboBox.setTranslateX(200);
        boardsComboBox.setTranslateY(130);
        labelForFontSizes.setTranslateX(80);
        labelForFontSizes.setTranslateY(190);
        fontSizesComboBox.setTranslateX(200);
        fontSizesComboBox.setTranslateY(190);
        reset.setTranslateX(80);
        reset.setTranslateY(250);
        back.setTranslateX(80);
        back.setTranslateY(310);
 
        // SettingsPane هنا قمنا بإضافة كل شيء قمنا بإنشائه في الحاوية التي يمثلها الكائن الذي ننشئه من الكلاس       
        getChildren().add(labelForBoards);
        getChildren().add(boardsComboBox);
        getChildren().add(labelForFontSizes);
        getChildren().add(fontSizesComboBox);
        getChildren().add(reset);
        getChildren().add(back);
        
        // boardsComboBox هنا قمنا بتحديد ما سيحدث عندما يقوم المستخدم بتغيير القيمة الظاهرة في الكائن
        // AppManager الموضوع في الكلاس preferredBoard بناءاً على القيمة التي يختارها سيتم تمرير إسم الصورة للمتغير الثابت
        boardsComboBox.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> ov, Number oldVal, Number newVal) -> {
                switch((int)newVal) {
                    case 0:
                        AppManager.preferredBoard = "board_1.png";
                        break;
                        
                    case 1:
                        AppManager.preferredBoard = "board_2.png";
                        break;
                        
                    case 2:
                        AppManager.preferredBoard = "board_3.png";
                        break;
                        
                    case 3:
                        AppManager.preferredBoard = "board_4.png";
                        break;
                }
        });
 
        // fontSizesComboBox هنا قمنا بتحديد ما سيحدث عندما يقوم المستخدم بتغيير القيمة الظاهرة في الكائن
        // AppManager الموضوع في الكلاس preferredFont بناءاً على القيمة التي يختارها سيتم تمرير حجم الخط للكائن الثابت
        // لتغيير حجم خط كل الأزرار, النصوص و مربعات النصوص الموضوعة في اللعبة setFont() كما أنه سيتم استدعاء الدالة
        fontSizesComboBox.getSelectionModel().selectedIndexProperty().addListener(
            (ObservableValue<? extends Number> ov, Number oldVal, Number newVal) -> {
                
            String selectedFont = fontSizesComboBox.getSelectionModel().getSelectedItem().toString();
            int fontSize = 0;

            switch(selectedFont) {
                case "Small":
                    fontSize = 15;
                    break;
                
                case "Medium":
                    fontSize = 16;
                    break;
                    
                case "Large":
                    fontSize = 17;
                    break;
            }
            
            AppManager.preferredFont = Font.font("Arial", FontWeight.BOLD, fontSize);
            AppManager.setFont();

        });
        
        // reset هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // لإرجاع القيم الإفتراضية التي كانت موضوعة في الحاوية AppManager الموجودة في الكلاس setDefaultSettings() سيتم استدعاء الدالة
        reset.setOnAction((Action) -> {
            AppManager.setDefaultSettings();
            boardsComboBox.getSelectionModel().selectFirst();
            fontSizesComboBox.getSelectionModel().select(1);
        });
        
        // back هنا قمنا بتحديد ما سيحدث عند النقر على الزر الذي يمثله الكائن
        // مكان الحاوية الحالية startPane لعرض الحاوية التي يمثلها الكائن viewPane() سيتم إستدعاء الدالة الثابتة
        back.setOnAction((Action) -> {
            AppManager.viewPane(AppManager.startPane);
        });
        
    }

}
