package zhang.ri.kang.snakeMain;

public class Node {
	private  int x;
	private  int y;
	public Node(int x, int y) {
		this.x = ((int)(x/10))*10;
		this.y = ((int)(y/10))*10;
	}//ʹ�����ַ�������ʹ�ýڵ����겻����ָ�λ��
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	@Override
	//�ж�����Node�Ƿ���ͬ
	public boolean equals(Object n) {
		Node temp;
		if(n instanceof Node) {
			temp = (Node)n;
			if(temp.getX()==this.getX() && temp.getY()==this.getY()) 
				return true;
		}
		return false;
	}
}
