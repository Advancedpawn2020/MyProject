package zhang.ri.kang.snakeMain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/*
 * ���մ���SnakeApp���ݹ�������������¼���Ȼ�󴫵ݸ�Grid����Grid��ʱ�ĸ���״̬��
 * ͬʱ��������״̬��Ⱦ����Ϸ������SnakeApp��ʾ
 * ����MVC�е�Controller���֣�����ת���û������¼������¼����д���
 * 
 */
public class GameController implements KeyListener, Runnable{
	private Grid grid;
	private boolean running;
	
	public GameController(Grid grid){
		this.grid = grid;
		this.running = true;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
        case KeyEvent.VK_UP:	
        	grid.changeDirection(Direction.UP); 
        	break;
        case KeyEvent.VK_DOWN:	
        	grid.changeDirection(Direction.DOWN); 
        	break;
        case KeyEvent.VK_LEFT:	
        	grid.changeDirection(Direction.LEFT); 
        	break;
        case KeyEvent.VK_RIGHT:	
        	grid.changeDirection(Direction.RIGHT); 
        	break;
		}
		isOver(grid.nextRound());
		GameView.draw();
	}

	private void isOver(boolean flag) {
		if(!flag) {//�����һ����������ʱ��������Ϸ��������ֵ�����flagΪ�٣���
			this.running = false;
			GameView.showGameOverMessage();
			System.exit(0);
		}
	}
	
	@Override
	/*run()�����еĺ����߼��ǵ��͵Ŀ�������Controller���߼���
	�޸�ģ�ͣ�Model��������Grid�ķ���ʹ��Ϸ������һ��
	������ͼ��View��������GameView�ķ���ˢ��ҳ��*/
	public void run() {
		while(running) {
			try {
				Thread.sleep(Settings.DEFAULT_MOVE_INTERVAL);
				isOver(grid.nextRound());
				GameView.draw();
			} catch (InterruptedException e) {
				break;
			}
			 // ������Ϸ��һ��
            // ������������˳���Ϸ
            // ���������������µ���Ϸҳ��
		}
		running = false;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	@Override
	public void keyReleased(KeyEvent e) {
	}
}
