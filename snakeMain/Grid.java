package zhang.ri.kang.snakeMain;

/*
 * �������ʳ�ά��̰���ߵ�״̬������SnakeApp�е��û�������������Ϸ״̬��
 */
public class Grid {
	private Snake snake;
	int width;
	int height;
	Node food;
	private Direction snakeDirection =Direction.LEFT;
	public Grid(int length, int high) {
		super();
		this.width = length;
		this.height = high;
		initSnake();
		food = creatFood();
	}
	
	//�������ϳ�ʼ��һ����
	private void initSnake() {
		snake = new Snake();
		int x = width/2;
		int y = height/2;
		for(int i = 0;i<5;i++) {
			snake.addTail(new Node(x, y));
			x = x+Settings.DEFAULT_NODE_SIZE;
		}
	}
	//�������������ʳ��Ĺ��ܡ�
	//һֱѭ����ȡ���ֵ��ֱ�����������������㡣
	private Node creatFood() {
		int x,y;
		do {
			x =(int)(Math.random()*100)+10;
			y =(int)(Math.random()*100)+10;
			System.out.println(x);
			System.out.println(y);
			System.out.println(this.width);
			System.out.println(this.height);
		}while(x>=this.width-10 || y>=this.height-10 || snake.hasNode(new Node(x,y)));
		food = new Node(x,y);
		return food;
	}
		
	//�ṩ��һ���������̵Ĺ��ܣ��ƶ��������Ϸ���ߵ�״̬��
	public boolean nextRound() {
		Node trail = snake.move(snakeDirection);
		Node snakeHead = snake.getBody().removeFirst();//��ͷ����ʱȥ�����ó����ж��Ƿ������ͷ�����غϵĵ�
		if(snakeHead.getX()<=width-10 && snakeHead.getX()>=10 
	    		&& snakeHead.getY()<=height-10 && snakeHead.getY()>=10
	    		&& !snake.hasNode(snakeHead)) {//�жϳԵ��Լ���ײ���߽�
			if(snakeHead.equals(food)) {
				//ԭ��ͷ����ʳ��Ļ�����move����ɾ����β����ӻ���
				snake.addTail(trail);
				food = creatFood();
			}
			snake.getBody().addFirst(snakeHead);
			return true;//��������״̬��������Ϸ�Ƿ�����ı�־
		}
		return false;
	}
	
	public Node getFood() {
		return food;
	}
	
	public Snake getSnake() {
		return snake;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	//�ṩһ������̰����ǰ������ķ���
	public void changeDirection(Direction newDirection){
	        snakeDirection = newDirection;
	}
}
