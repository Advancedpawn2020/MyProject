package zhang.ri.kang.snakeMain;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
/*
 * ����View�����ڻ��Ƶ�ͼ���ߡ�ʳ��
 * 
 * Graphics �൱��һ�����ʡ������װ�� Java ֧�ֵĻ������ֲ��������״̬��Ϣ����״̬��Ϣ�����������ԣ�
	
	Ҫ�����ϻ��Ƶ� Component ����
	���ֺͼ��������ת��ԭ�㡣
	��ǰ��������
	��ǰ��ɫ��
	��ǰ���塣
	��ǰ�߼����ز���������XOR �� Paint����
	��ǰ XOR ������ɫ
	
	�ص����
	 A����B�еķ���b����Ҫ����A�������ã�����bִ����Ϻ������ô����A�����ã�����A�еķ���
	 
	java.awt.Component��repaint()����
	 ���ã����������
		�������������������������Ϊ����Ӧ�� repaint �ĵ��ã�AWT ���� update ���������Լٶ�δ���������
		Component �� update �������ô������ paint �������ػ�������Ϊ��Ӧ�� repaint �ĵ��ö���Ҫ��������������ͨ����д�˷�������д�˷����� Component ����Ӧ�õ��� super.update(g)������ֱ�Ӵ��� update �����е��� paint(g)��
		ͼ�������ĵ�ԭ�㣬�����ģ�0��0��������Ǵ���������Ͻǡ�ͼ�������ĵļ��������Ǵ�����ı߽���Ρ�
 */
public class GameView {
	private final Grid grid;
	private static JPanel canvas;//���壬�������������������棬Ȼ�󷵻ء�
	
	public GameView(Grid grid) {
		this.grid = grid;
	}
	//���»�����Ϸ����Ԫ�أ��������µ���paintComponent��������ԭ������塣
	 public static void draw() {
	    	canvas.repaint();
	    }
	    //��ȡ�������Ľӿ�
	 public JPanel getCanvas() {
	    	return canvas;
	    }
	//�Ի�����г�ʼ��
	public void initCanvas() {
		canvas = new JPanel() {//ָ��һ�����������ǵ�������������
			//paintComponent()���ƴ������е�ÿ�������Swing���ں��ʵ�ʱ��ȥ�������������չʾ�����ʵĽ��棬����ǵ��͵Ļص���callback���ĸ��
			public void paintComponent(Graphics graphics) {
				super.paintComponent(graphics); //����������һ�¸��� Ҳ���� container���ػ淽�����������Ϊ֮ǰ�Ļ�ͼ���Ḳ��
				drawGridBackground(graphics);//��������������
				drawSnake(graphics, grid.getSnake());//����
		        drawFood(graphics, grid.getFood());//��ʳ��
			}
		};
	}
	//����
    public void drawSnake(Graphics graphics, Snake snake) {
    	for(Iterator<Node> i = snake.body.iterator();i.hasNext();) {
    		Node bodyNode = (Node)i.next();
    		drawSquare(graphics, bodyNode,Color.BLUE);
    	}
    }
    //��ʳ��
    public void drawFood(Graphics graphics, Node food) {
    	drawCircle(graphics,food,Color.ORANGE);
    }
    
  //�����ӱ��������㶨λSnake�˶��켣,��������10Ϊ��λ��50���ߡ�
    public void drawGridBackground(Graphics graphics) {
    	graphics.setColor(Color.GRAY);
    	canvas.setBackground(Color.BLACK);
    	for(int i=0 ; i < 50 ; i++) {
    		graphics.drawLine(0, i*Settings.DEFAULT_NODE_SIZE, this.grid.getWidth(), i*Settings.DEFAULT_NODE_SIZE);
    	}
    	for(int i=0 ; i <50 ; i++) {
    		graphics.drawLine(i*Settings.DEFAULT_NODE_SIZE, 0,  i*Settings.DEFAULT_NODE_SIZE , this.grid.getHeight());
    	}
    	graphics.setColor(Color.red);
    	graphics.fillRect(0, 0, this.grid.width, Settings.DEFAULT_NODE_SIZE);
    	graphics.fillRect(0, 0, Settings.DEFAULT_NODE_SIZE, this.grid.height);
    	graphics.fillRect(this.grid.width, 0, Settings.DEFAULT_NODE_SIZE,this.grid.height);
    	graphics.fillRect(0, this.grid.height, this.grid.width+10,Settings.DEFAULT_NODE_SIZE);
    	
    }
    /*
     * public abstract void drawLine(int x1,int y1,int x2,int y2)
		�ڴ�ͼ�������ĵ�����ϵ�У�ʹ�õ�ǰ��ɫ�ڵ� (x1, y1) �� (x2, y2) ֮�仭һ���ߡ�
		������
				x1 - ��һ����� x ���ꡣ
				y1 - ��һ����� y ���ꡣ
				x2 - �ڶ������ x ���ꡣ
				y2 - �ڶ������ y ���ꡣ
     */
    //�ṩֱ�ӳ�����Ϸ������ѡ���Ĺ��ܡ�
    public static void showGameOverMessage() {
    	JOptionPane.showMessageDialog(null,"��Ϸ����","���ݵ��������˽���", JOptionPane.INFORMATION_MESSAGE);
    }
    

//��ͼ�εľ��巽����
private void drawSquare(Graphics graphics, Node squareArea, Color color) {
    graphics.setColor(color);
    int size = Settings.DEFAULT_NODE_SIZE;
    graphics.fillRect(squareArea.getX(), squareArea.getY(), size - 1, size - 1);
}

private void drawCircle(Graphics graphics, Node squareArea, Color color) {
    graphics.setColor(color);
    int size = Settings.DEFAULT_NODE_SIZE;
    graphics.fillOval(squareArea.getX(), squareArea.getY(), size, size);
}

}

