package zhang.ri.kang.snakeMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
/*
 * 	���ֹ��ܣ����Դ����÷ֹ�����ࣨģ�����һ���֣��� ��GameController��run()�����м���÷�

	���ٹ��ܣ�������ٹ��ܣ����ٹ��ܣ�������GameController��keyPressed()����������ض��İ�������ÿһ���ƶ�֮���ʱ��������Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);�滻Ϊ��̬��ʱ��������

	��Ư������Ϸ���棺�޸�GameView�е�drawXXX������������Խ�ʳ����ȾΪһ��ͼƬ��Graphics��drawImage����
 */
/*
 * ����View������������Ӧ����չʾ����Ӧ����Ϸ�����棬Ҳ�ǽ��տ�����Ϣ�ĵ�һ�ߡ�
 */
public class SnakeApp {
    public void init() {
        //������Ϸ����
        JFrame window = new JFrame("һֻ���������");
        //��ʼ��500X500������,����ά�ָ�����ϷԪ�ص�״̬����Ϸ����Ҫ�߼�����
        Grid grid = new Grid(50*Settings.DEFAULT_NODE_SIZE,50*Settings.DEFAULT_NODE_SIZE);
        //����grid�������½�����Ԫ�ض���
        GameView gameView = new GameView(grid);//������ϷԪ�صĶ���
        //��ʼ�����
        gameView.initCanvas();
        //����������Ϣ��������������
        GameController gameController = new GameController(grid);
       
        //���ô��ڴ�С
        window.setPreferredSize(new Dimension(526,548));
        
        //�����������Ԫ�أ������󱻼��뵽����ʱ���Զ��������е�paintComponent������
        window.add(gameView.getCanvas(),BorderLayout.CENTER);
        
        //�����ߺ����̺�ʳ��
        GameView.draw();
        
        //ע�ᴰ�ڼ�����
        window.addKeyListener((KeyListener)gameController);
        
        //�����߳�
        new Thread(gameController).start();
        
        //���ڹرյ���Ϊ
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô��ڴ�С���ɱ仯
        window.setResizable(false);
        //��Ⱦ����ʾ����
        window.pack();
        window.setVisible(true);
    }

    public static void main(String[] args) {
        SnakeApp snakeApp = new SnakeApp();
        snakeApp.init();
    }
}
