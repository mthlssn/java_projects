package time_cont;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class main {

	public static void main(String[] args) {
		
		File folderTimers = new File("programs");
		folderTimers.mkdir();
		
		File[] timersFile = folderTimers.listFiles();
		String[] timersName = new String[timersFile.length];
		
		Scanner sc = new Scanner(System.in);
		
		JSONObject jsonObject;
		JSONParser parser = new JSONParser();
		
		ArrayList<String> times = new ArrayList<String>(); 
		
		System.out.println("\ncontador de horas \n");
		
	    
		int cont = 0;
	    for (File file : timersFile) {
	    	
	    	String f = file.toString();
	    	f = f.substring(f.indexOf("/") + 1, f.indexOf("."));
	    	timersName[cont] = f;
	        
	        System.out.println("["+ (cont+1) +"] " + f);
	        cont++;
	    }
		
		System.out.println("\n[n] novo");
		System.out.println("[q] sair");
		
		System.out.print("\n: ");
		String choise = sc.nextLine();
		
		if ("n".contains(choise)) {
			
			System.out.print("\nDigite o novo trabalho: ");
			String newFile = sc.nextLine();
			
			FileWriter writeFile = null;
			
			JSONObject objJson = new JSONObject();

			objJson.put("dates", times);
			
			try {
				writeFile = new FileWriter("programs/"+newFile+".json");
				writeFile.write(objJson.toJSONString());
				writeFile.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		} else if ("q".contains(choise)) {
			System.out.println("SAIR");

		} else {
			boolean verificacao = false;
			for (int i = 0; i < choise.length(); i++) {
				verificacao = "0123456789".contains(choise.substring(i, i+1));
				
				if (!verificacao) {
					break;
				}
			}
			
			
			if (verificacao && Integer.parseInt(choise) <=  timersFile.length) {
				try {
					jsonObject = (JSONObject) parser.parse(new FileReader(timersFile[Integer.parseInt(choise) - 1]));
					
					times = (ArrayList<String>) jsonObject.get("dates");
					
					Date dataHoraAtual = new Date();
					times.add(dataHoraAtual.toString());
		
					jsonObject.clear();
					
					jsonObject.put("dates", times);
					
					FileWriter writeFile = null;
					
					try {
						writeFile = new FileWriter("programs/"+timersName[Integer.parseInt(choise) - 1]+".json");
						writeFile.write(jsonObject.toJSONString());
						writeFile.close();
					} catch (Exception e) {
						// TODO: handle exception
					}
					
					System.out.println(times);
				} catch (Exception e) {
	 				// TODO: handle exception
				}
			}
		}

		
		
		
		
		
		
		
		
		
		
		
//		
//		Date dataHoraAtual = new Date();
//		System.out.println(dataHoraAtual);
//		
//		String data = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy").format(dataHoraAtual);
//		System.out.println(data);
//		
////		---------------------------------
////		
//		
//		JSONObject objJson1 = new JSONObject();
//		JSONObject objJson2 = new JSONObject();
////		
////		Date[] data1 = {};
//		
//		objJson1.put("datas", 32);
//		
//		FileWriter writeFile = null;
//		
//		try {
//			writeFile = new FileWriter("dados.json");
//			writeFile.write(objJson1.toJSONString());
//			writeFile.close();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
////		
//		System.out.println(objJson1);
//		
////		---------------------------------
		
		
//		List<Date> datas = new ArrayList<Date>();
//		
//		datas.add(dataHoraAtual);
//		datas.add(dataHoraAtual);
//		
//		datas.remove(0);
//		
//		System.out.println(datas);
//		
//		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//		
		
//		Properties properties = System.getProperties();
//        System.out.println(properties.toString());
//        System.out.println( System.getProperty("os.name") ); 
		

// - DELETAR ARQUIVOS
//		File file = new File("dados.json");
//		
//		if(file.delete())
//        {
//            System.out.println("File deleted successfully");
//        }
//        else
//        {
//            System.out.println("Failed to delete the file");
//        }
		

// - Criar arquivo	
//		File file = new File("dados.json");
//		
//		try {
//			boolean value = file.createNewFile();
//			if (value) {
//				System.out.println("criado");
//			} else {
//				System.out.println("existe");
//			}
//		} catch (Exception e) {
//			e.getStackTrace();
//		}
		
	}

}
