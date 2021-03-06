package control;

import javax.swing.JFrame;

public class DebugTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Debug now.");
		System.out.println(new JFrame(){
			public String toString(){
				return "This is a JFrame";
			}
		});
		// 红色字体显示错误信息
		System.err.println("Debug now.");
		
		int[] ints = new int[20];
		
		try {
			for(int i=0;i<21;i++){
				ints[i] = i+1;
				System.out.println(i+1);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println("数组越界");
		}
		
		// 快捷键, Cmd + 1, 显示提示代码
		// 快捷键, Cmd + D, 快捷删除行
		// Shift + Enter, 创建新的行
		// Cmd + F11, 快速运行
		// Alt + ↑／↓, 快速移动行
		// Cmd + Alt + ↑／↓, 快速复制行
		int a = (int) 100L;		
		// Ctrl ＋ M, 将当前视图放大
		// Alt + / ,自动补全代码
		// Cmd + / , 快速注释代码
	}
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public String ok(int a, int b, boolean c){
		return "";
	}
}
