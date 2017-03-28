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
import java.nio.channels.FileChannel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFileChooser;

import Classes.Empresa;
import Classes.Login;
import Criptografia.CriptoProj;

public class Txt {
	static String nome;
	static File arquivo, arquivoTmp;
	static String contas[];
	static File saida;
	static int ultimoId;
	static String tipo;
	public Txt() {
	}

	public static String[] numContas() throws IOException// modificado
	{
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		String linha = null;
		String vet[] = null;
		int contador = 0;
		while (br.readLine() != null) {
			contador++;
		}
		vet = new String[contador];
		for (int i = 0; (linha = br.readLine()) != null; i++) {
			vet[i] = linha;
		}
		br.close();
		entrada.close();
		return vet;
	}

	public static boolean binaria(int conta, String vet[]) {
		int n = contas.length, inicio = 0, fim = n - 1, meio;
		while (inicio <= fim) {
			meio = (inicio + fim) / 2;
			if (conta == Integer.parseInt(vet[2])) {

				return true;
			} else if (Integer.parseInt(vet[2]) < conta)
				inicio = meio + 1;
			else
				fim = meio - 1;
		}
		return false;
	}

	public static boolean confere(Login login) throws IOException, Exception {
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		while ((linha = br.readLine()) != null) {
			String vet[] = linha.split(";");
			String agenciaLida = vet[0];
			String senhaLida = vet[1];
			String idLido = vet[2];
			String tipoLido = vet[3];
			/*if (agenciaLida.equals( senhaLida.equals(login.getSenha()) && login.getTipo().equals(tipoLido)) {
				login.setId(Integer.parseInt(idLido));
				br.close();
				entrada.close();
				return true;
			}*/
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
			sourceChannel.transferTo(0, sourceChannel.size(), destinationChannel);
		} finally {
			if (sourceChannel != null && sourceChannel.isOpen())
				sourceChannel.close();
			if (destinationChannel != null && destinationChannel.isOpen())
				destinationChannel.close();
		}
	}

	public static String[] confereId(String[] saida, int id) throws IOException {
		File file = getProjPath();
		String linha = null;
		InputStream entrada = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		while ((linha = br.readLine()) != null) {
			String vet[] = linha.split(";");
			String idLido = vet[3];
			String agenciaLida = vet[0];
			String contaLida = vet[1];
			if (idLido.equals(id + "")) {
				br.close();
				entrada.close();
				saida[0] = agenciaLida;
				saida[1] = contaLida;
				return saida;
			}
		}
		br.close();
		entrada.close();
		return null;
	}

	public static boolean confere(String agencia, String conta, String senha) throws IOException {
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		while ((linha = br.readLine()) != null) {
			String vet[] = linha.split(";");
			String agenciaLida = vet[0];
			String contaLida = vet[1];
			String senhaLida = vet[2];
			if (agenciaLida.equals(agencia) && contaLida.equals(conta) && senhaLida.equals(senha)) {
				br.close();
				entrada.close();
				return true;
			}
		}
		br.close();
		entrada.close();
		return false;
	}

	public static int confere(String agencia, String conta) throws IOException {
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		while ((linha = br.readLine()) != null) {
			String vet[] = linha.split(";");
			String agenciaLida = vet[0];
			String contaLida = vet[1];
			if (agenciaLida.equals(agencia) && contaLida.equals(conta)) {
				br.close();
				entrada.close();
				return Integer.parseInt(vet[3]);
			}
		}
		br.close();
		entrada.close();
		return -1;
	}

	public static String retornaTransacoes(int id, String pais) throws IOException {
		String linha = null;
		String saida = "";
		File file = getExtratoPath(pais);
		InputStream entrada = new FileInputStream(file);
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		while ((linha = br.readLine()) != null) {
			String vet[] = linha.split(";");
			String idLido = vet[0];
			String Transacao = vet[1];
			if (Integer.parseInt(idLido) == id)
				saida += Transacao;
		}
		br.close();
		entrada.close();
		return saida;
	}

	public static void salvarExtrato(File file, int id, String operacao, String pais) throws IOException {
		file = getExtratoPath(pais);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		if (file.canWrite()) {
			bw.write(id + ";" + operacao);
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		}
		bw.close();
	}

	public static void salvarPessoa(Login login, String pais) throws Exception {
		File file = getProjPath();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		Date date = new Date();
		CriptoProj.encrypt(login.getSenha());
		login.setSenha(CriptoProj.getBytes());
		if (file.canWrite()) {
			if (login.getTipo().equals("Sindico") || login.getTipo().equals("Atendente")) {
				bw.write(login.getId() + ";" + login.getSenha() + ";" + login.getTipo() + ";"+"Livre"+";"+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date));
			}
			else{
				bw.write(login.getId() + ";" + login.getSenha() + ";" + login.getTipo() + ";"+"Nao"+";"+new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date));
			}
			bw.newLine();
			bw.flush();
			bw.close();
			ultimoId = login.getId();
			return;
		}
		bw.close();
	}

	private static File getExtratoPath(String pais) {
		File file;
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		file = new File(chooser.getCurrentDirectory() + "\\ProjetoSistCaixa\\Extratos_" + pais + ".txt");
		return file;
	}

	public static void setUp() throws IOException {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = new File(chooser.getCurrentDirectory() + "//ProjetoArqdesis");
		if (!file.exists()) {
			file.mkdir();
			copyFile(new File("login.txt"),
					file = new File(chooser.getCurrentDirectory() + "//ProjetoArqdesis//login.txt"));
			copyFile(new File("blocosDeEmpresas.txt"),
					file = new File(chooser.getCurrentDirectory() + "//ProjetoArqdesis//blocosDeEmpresas.txt"));
		}
	}

	public static boolean confereSenha(Login login) throws IOException, Exception {
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha = null;
		CriptoProj.encrypt(login.getSenha());
		login.setSenha(CriptoProj.getBytes());
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		while ((linha = br.readLine()) != null) {
			String vet[] = linha.split(";");
			String idLido = vet[0];
			String senhaLida = vet[1];
			String tipoLido = vet[2];
			if (senhaLida.equals(login.getSenha())) {
				login.setTipo(tipoLido);
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


	public static String getIdConta(String conta) throws IOException {
		File file = getProjPath();
		InputStream entrada = new FileInputStream(file);
		String linha = null;
		BufferedReader br = new BufferedReader(new InputStreamReader(entrada));
		String vet[];
		while ((linha = br.readLine()) != null) {
			vet = linha.split(";");
			if (conta.equals(vet[1])) {
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
		File file = new File(chooser.getCurrentDirectory() + "//ProjetoArqdesis//login.txt");
		return file;
	}
	
	private static File getEmpresaPath() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		File file = new File(chooser.getCurrentDirectory() + "//ProjetoArqdesis//blocosDeEmpresas.txt");
		return file;
	}
	
	public static void salvarEmpresa(Empresa e,String pais) throws IOException, ParseException
	{
		File file = getEmpresaPath();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
		Date date = new Date();
		
		if (file.canWrite()) {
			bw.write(e.getCnpj() + ";" + e.getRazaoSocial() + ";" + e.getConjunto() + ";"+e.getHorarioFuncionamento()+";"+e.getTempMax()+";"+e.getTempPadrao()+";"+new SimpleDateFormat("dd/MM/yyyy").format(date));
			
			bw.newLine();
			bw.flush();
			bw.close();
			return;
		}
		bw.close();
	}

	public static void main(String args[]) throws Exception {
		try {
			Txt.setUp();
			Login login = new Login("rxrxrx","Funcionario",4);
			Txt.salvarPessoa( login, "BR");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
