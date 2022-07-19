import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    
    @Override
    public void start(Stage stage) {
        
        // لتحديد خصائص الخط الإفتراضي الذي سيتم وضعه لكل setDefaultSettings() هنا قمنا باستدعاء الدالة الثابتة
        // زر, نص و مربع نص تم وضعه في اللعبة. بالإضافة إلى الصورة التي سيتم وضعها كخلفية في حاوية اللعب
        AppManager.setDefaultSettings();
        
        // لكل الحاويات التي سنضعها في اللعبة Root Node و الذي سنضعه كـ Pane هنا قمنا بإنشاء كائن من الكلاس
        Pane root = new Pane();
        
        // حتى نكون قادرين على عرضها في النافذة root في الكائن AppManager هنا قمنا بإضافة جميع الحاويات التي أنشأناها في الكلاس
        root.getChildren().add(AppManager.startPane);
        root.getChildren().add(AppManager.singlePlayerPane);
        root.getChildren().add(AppManager.multiPlayerPane);
        root.getChildren().add(AppManager.settingsPane);
        root.getChildren().add(AppManager.gamePane);
        
        // لها لأننا نريد عرض هذه الحاوية في النافذة عند تشغيل اللعبة startPane و تمرير الحاوية AppManager من الكلاس viewPane() هنا قمنا باستدعاء الدالة الثابتة
        AppManager.viewPane(AppManager.startPane);

        // فيها و تحديد حجمها Node كأول root هنا قمنا بإنشاء محتوى النافذة مع تعيين الكائن
        Scene scene = new Scene(root, 380, 500);
        
        // هنا قمنا بإنشاء و إظهار نافذة اللعبة مع جعل حجمها غير قابل للتكبير أو التصغي
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
