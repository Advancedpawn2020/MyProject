package zhang.ri.kang.snakeMain;
/*
 * ���������ߵ��ƶ�����
 */
public enum Direction {
	UP(0),
	DOWN(1),
	LEFT(2),
	RIGHT(3); //���ù��췽���Է���ö��ʵ�����д����ʼ��
	//��Ա����
	private final int directionCode;
	
	//��Ա����
	public int directionCode() {
		return directionCode;
	}
	Direction(int directionCode){
		this.directionCode = directionCode;
	}
}
