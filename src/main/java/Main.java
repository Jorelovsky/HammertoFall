import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // 创建一个标签
        Label label = new Label("欢迎使用 JavaFX！");

        // 创建一个按钮
        Button button = new Button("点击我");

        // 为按钮添加点击事件处理
        button.setOnAction(event -> label.setText("按钮被点击了！"));

        // 将标签和按钮放入垂直布局容器中
        VBox root = new VBox(10); // 间距为10像素
        root.getChildren().addAll(label, button);

        // 创建场景，设置宽度和高度
        Scene scene = new Scene(root, 300, 200);

        // 设置舞台标题和场景，并显示
        primaryStage.setTitle("JavaFX 示例");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
       launch(args);
    }

}