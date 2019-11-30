import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

public class TableData extends AbstractTableModel{
	private List<Transaction> list;
	public TableData(){
		updateList();
	}
	
	public void updateList(){
		list = new ArrayList<>();
		try{			
			Scanner sc = new Scanner(new File("./data.csv"));
			for(int i = 0; sc.hasNextLine();i++){
				String[] data = sc.nextLine().split(",");
				if(i != 0){
					Transaction t = new Transaction();
					TransactionBuilder tb = new TransactionBuilder(t);
					t = tb
							.name(data[0])
							.type(data[1])
							.amount(Double.parseDouble(data[2]))
							.note(data[3])
							.transaction();
					list.add(t);
				}
			}
				
		}catch(Exception e){
			e.printStackTrace();
		}
		for(Transaction t: list){
			System.out.println(t);
		}
	}
	
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}
	public Object getValueAt(int row, int cell) {
		// TODO Auto-generated method stub
		return null;
	}

}
