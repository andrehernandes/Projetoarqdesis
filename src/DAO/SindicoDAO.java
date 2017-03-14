package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ConnectionFactory.ConnectionFactory;
import TO.AtendenteTO;
import TO.EmpresaTO;
import TO.FuncionarioTO;

public class SindicoDAO {

	public void cadastrarFuncionario(FuncionarioTO to)
	{
			String sqlCommand = "INSERT INTO Funcionario(nome, cpf, dataCadastro, horarioEntrada,horarioSaida) values(?,?,?,?,?)";
			try (Connection conn = ConnectionFactory.obtemConexao();)
        	{
        		PreparedStatement stm=null;
        		stm=conn.prepareStatement(sqlCommand);
        		stm.setString(1,to.getNome());
        		stm.setString(2,to.getCpf());
        		stm.setString(3,to.getData());
        		stm.setString(4,to.getHorarioEntrada());
        		stm.setString(5,to.getHorarioSaida());
        		stm.execute();
        		stm.close();
        	}
			catch(SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
	public void removerFuncionario(FuncionarioTO to)
	{
		String sqlCommand = "DELETE FROM Funcionario where idFuncionario=? ";
		try (Connection conn = ConnectionFactory.obtemConexao();)
    	{
    		PreparedStatement stm=null;
    		stm=conn.prepareStatement(sqlCommand);
    		stm.setInt(1,to.getIdFuncionario());
    		stm.execute();
    		stm.close();
    	}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	public void cadastrarEmpresa(EmpresaTO to)
	{
		String sqlCommand = "INSERT INTO Empresa(CNPJ,razaoSocial,conjunto,horFuncionamento,tempMax,tempPadrao) values(?,?,?,?,?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();)
    	{
    		PreparedStatement stm=null;
    		stm=conn.prepareStatement(sqlCommand);
    		stm.setString(1,to.getCnpj());
    		stm.setString(2,to.getRazaoSocial());
    		stm.setInt(3,to.getConjunto());
    		stm.setString(4,to.getHorarioFuncionamento());
    		stm.setInt(5,to.getTempMax());
    		stm.setInt(6,to.getTempPadrao());
    		stm.execute();
    		stm.close();
    	}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
	public void cadastrarAtendente(AtendenteTO to){
		String sqlCommand = "INSERT INTO Atendente(nome,cpf) values(?,?)";
		try (Connection conn = ConnectionFactory.obtemConexao();)
    	{
    		PreparedStatement stm=null;
    		stm=conn.prepareStatement(sqlCommand);
    		stm.setString(1,to.getNome());
    		stm.setString(2,to.getCpf());
    		stm.execute();
    		stm.close();
    	}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	
}