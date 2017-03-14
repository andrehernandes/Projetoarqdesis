package Catraca;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.channels.FileChannel;
import java.util.Properties;

import javax.swing.JFileChooser;

import Classes.Login;
import Criptografia.CriptoProj;

public class Txt {
	static String nome;
	static File arquivo,arquivoTmp;
	static String contas[];
	static File saida;

	public Txt()
	{}

	public static  String[] numContas()throws IOException//modificado
	{
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		String linha=null;
		String vet[]=null;
		int contador=0;
		while(br.readLine()!=null)
		{
			contador++;
		}
		vet = new String[contador];
		for(int i =0;(linha  =br.readLine())!=null;i++)
		{
			vet[i] = linha;
		}
		br.close();
		entrada.close();
		return vet;
	}     
	

	public static boolean binaria(int conta, String vet[])
	{
		int n = contas.length, inicio=0,fim=n-1,meio;
		while(inicio<=fim)
		{
			meio = (inicio+fim)/2;
			if(conta==Integer.parseInt(vet[2])){
				
				return true;
				}
			else if(Integer.parseInt(vet[2])<conta)
				inicio=meio+1;
			else
				fim=meio-1;
		}
		return false;
	}
	public static boolean confere(Login login)  
			throws IOException,Exception {  
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha =null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));  
		while((linha = br.readLine())!=null)
		{
			String vet[] = linha.split(";");
			String agenciaLida = vet[0];
			String senhaLida = vet[1];
			String idLido = vet[2];
			String tipoLido = vet[3];
			if(agenciaLida.equals(login.getUsuario())&&senhaLida.equals(login.getSenha())&&login.getTipo().equals(tipoLido)){
				login.setId(Integer.parseInt(idLido));
				br.close();
				entrada.close();
				return true;
			}
		}
		br.close();
		entrada.close();

		return false;  
	}
	public static void copyFile(File source, File destination) throws IOException {
		if (destination.exists())
			destination.delete();
		FileChannel sourceChannel = null;
		FileChannel destinationChannel = null;
		try {
			sourceChannel = new FileInputStream(source).getChannel();
			destinationChannel = new FileOutputStream(destination).getChannel();
			sourceChannel.transferTo(0, sourceChannel.size(),
					destinationChannel);
		} finally {
			if (sourceChannel != null && sourceChannel.isOpen())
				sourceChannel.close();
			if (destinationChannel != null && destinationChannel.isOpen())
				destinationChannel.close();
		}
	}
	public static String[] confereId(String[]saida,int id)  
			throws IOException {  
		File file = getProjPath();
		String linha =null;
		InputStream entrada = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));   
		while((linha = br.readLine())!=null)
		{
			String vet[] = linha.split(";");
			String idLido = vet[3];
			String agenciaLida=vet[0];
			String contaLida=vet[1];
			if(idLido.equals(id+""))
			{
				br.close();
				entrada.close();
				saida[0]=agenciaLida;
				saida[1]=contaLida;
				return saida;}
		}
		br.close();
		entrada.close();
		return null;  
	}

	public static boolean confere(String agencia,String conta,String senha)  
			throws IOException {  
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha =null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));   
		while((linha = br.readLine())!=null)
		{
			String vet[] = linha.split(";");
			String agenciaLida = vet[0];
			String contaLida = vet[1];
			String senhaLida = vet[2];
			if(agenciaLida.equals(agencia)&&contaLida.equals(conta)&&senhaLida.equals(senha))
			{
				br.close();
				entrada.close();
				return true;
			}
		}
		br.close();
		entrada.close();
		return false;
	}

	public static int confere(String agencia,String conta)  
			throws IOException {  
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha =null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));   
		while((linha = br.readLine())!=null)
		{
			String vet[] = linha.split(";");
			String agenciaLida = vet[0];
			String contaLida = vet[1];
			if(agenciaLida.equals(agencia)&&contaLida.equals(conta))
			{
				br.close();
				entrada.close();
				return Integer.parseInt(vet[3]);
			}
		}
		br.close();
		entrada.close();
		return -1;
	}





	public static String retornaTransacoes(int id,String pais)throws IOException
	{
		String linha =null;
		String saida="";
		File file = getExtratoPath(pais);
		InputStream entrada = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada)); 
		while((linha = br.readLine())!=null)
		{
			String vet[] = linha.split(";");
			String idLido = vet[0];
			String Transacao = vet[1];
			if(Integer.parseInt(idLido)==id)
				saida+=Transacao;
		}
		br.close();
		entrada.close();
		return saida;
	}


	public static void salvarExtrato(File file,int id,String operacao,String pais)throws IOException
	{
		file = getExtratoPath(pais);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		if(file.canWrite())
		{
			bw.write(id+";"+operacao);
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		}
		bw.close();
	}
	
	public static void salvarPessoa(File file,Login login,String pais)throws IOException
	{
		file = getExtratoPath(pais);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		if(file.canWrite())
		{
			bw.write(login.getId()+";"+login.getUsuario()+";"+login.getSenha()+";"+login.getTipo());
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		}
		bw.close();
	}

	private static File getExtratoPath(String pais) {
		File file;
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa\\Extratos_"+pais+".txt");
		return file;
	}

	


	public static void setUp() throws IOException
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa");
		if(!file.exists())
		{
			file.mkdir();
			copyFile(new File("proj.txt"),file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa\\proj.txt"));
			copyFile(new File("Extratos_BR.txt"),file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa\\Extratos_BR.txt"));
			copyFile(new File("Extratos_US.txt"),file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa\\Extratos_US.txt"));
			copyFile(new File("Extratos_ES.txt"),file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa\\Extratos_ES.txt"));
			copyFile(new File("Dispenser.txt"),file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa\\Dispenser.txt"));
		}
	}

	 

	public static boolean confereSenha(Login login)
			throws IOException,Exception {
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha =null;
		CriptoProj.encrypt(login.getSenha());
		login.setSenha(CriptoProj.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));   
		while((linha = br.readLine())!=null)
		{
			String vet[] = linha.split(";");

			String senhaLida = vet[2];
			if(senhaLida.equals(login.getSenha()))
			{
				br.close();
				entrada.close();
				return true;
			}
		}
		br.close();
		entrada.close();
		return false; 
	}  

	public static String getValor1()
			throws IOException {  
		Properties p = new Properties();  
		File file = getDispenserPath();
		p.load(new FileInputStream(/*"C:\\Users\\dudu9.DESKTOP-35BTD19\\workspace\\Projeto\\src\\txt\\Dispenser.txt"*/file));  
		String nota1Lido = p.getProperty("nota1");  
		return nota1Lido;
	}

	private static File getDispenserPath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = new File(chooser.getCurrentDirectory()+"\\ProjetoSistCaixa\\Dispenser.txt");
		return file;
	} 
	public static String getValor5()
			throws IOException {  
		Properties p = new Properties();
		File file = getDispenserPath();
		p.load(new FileInputStream(/*"C:\\Users\\dudu9.DESKTOP-35BTD19\\workspace\\Projeto\\src\\txt\\Dispenser.txt"*/file)); 
		String nota5Lido = p.getProperty("nota5");  
		return nota5Lido;
	}
	public static String getValor10()
			throws IOException {  
		Properties p = new Properties();
		File file = getDispenserPath();
		p.load(new FileInputStream(/*"C:\\Users\\dudu9.DESKTOP-35BTD19\\workspace\\Projeto\\src\\txt\\Dispenser.txt"*/file)); 
		String nota10Lido = p.getProperty("nota10");  
		return nota10Lido;
	}
	public static String getValor20()
			throws IOException {  
		Properties p = new Properties();  
		File file = getDispenserPath();
		p.load(new FileInputStream(/*"C:\\Users\\dudu9.DESKTOP-35BTD19\\workspace\\Projeto\\src\\txt\\Dispenser.txt"*/file)); 
		String nota20Lido = p.getProperty("nota20");  
		return nota20Lido;
	}
	public static String getValor50()
			throws IOException {  
		Properties p = new Properties();  
		File file = getDispenserPath();
		p.load(new FileInputStream(/*"C:\\Users\\dudu9.DESKTOP-35BTD19\\workspace\\Projeto\\src\\txt\\Dispenser.txt"*/file));  
		String nota50Lido = p.getProperty("nota50");  
		return nota50Lido;
	}
	public static String getValor100()
			throws IOException {  
		Properties p = new Properties();  
		File file = getDispenserPath();
		p.load(new FileInputStream(/*"C:\\Users\\dudu9.DESKTOP-35BTD19\\workspace\\Projeto\\src\\txt\\Dispenser.txt"*/file));  
		String nota100Lido = p.getProperty("nota100");  
		return nota100Lido;
	}

	public static String getIdConta(String conta)throws IOException
	{
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha =null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));   
		String vet[];
		while((linha = br.readLine())!=null)
		{
			vet = linha.split(";");
			if(conta.equals(vet[1]))
			{
				br.close();
				entrada.close();
				return vet[3];
			}
		}
		br.close();
		entrada.close();
		return "-1"; 
	}

	private static File getProjPath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = new File(chooser.getCurrentDirectory()+"\\ProjetoArqdesis\\proj.txt");
		return file;
	}

}
