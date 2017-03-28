package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectionFactory.ConnectionFactory;
import TO.AtendenteTO;
import TO.EmpresaTO;
import TO.FuncionarioTO;

public class SindicoDAO {

	public void cadastrarFuncionario(FuncionarioTO to)
	{
			String sqlCommand = "INSERT INTO Funcionario(nome, cpf, dataCadastro, horarioEntrada,horarioSaida) VALUES(?,?,?,?,?)";
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
		String sqlCommand = "DELETE FROM Funcionario WHERE idFuncionario=? ";
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
	
	public void selecionarFuncionario(FuncionarioTO to) throws SQLException
	{
		String sqlCommand = "select * from Funcionario where idFuncionario=?";
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.obtemConexao();)
    	{
    		PreparedStatement stm=null;
    		stm=conn.prepareStatement(sqlCommand);
    		stm.setInt(1,to.getId());
    		rs = stm.executeQuery();
  	      if(rs.next()){  
  	         to.setNome(rs.getString("nome"));
  	         to.setCpf(rs.getString("cpf"));
  	         to.setId(rs.getInt("idFuncionario"));
  	         to.setData(rs.getString("dataCadastro"));
  	         to.setHorarioEntrada(rs.getString("horarioEntrada"));
  	         to.setHorarioSaida(rs.getString("horarioSaida"));
  	      }
    		stm.close();
    	}
	}
	
	public void cadastrarEmpresa(EmpresaTO to)
	{
		String sqlCommand = "INSERT INTO Empresa(CNPJ,razaoSocial,conjunto,horFuncionamento,tempMax,tempPadrao) VALUES(?,?,?,?,?,?)";
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
		String sqlCommand = "INSERT INTO Atendente(nome,cpf) VALUES(?,?)";
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
	
	public void selecionarAtendente(AtendenteTO to) throws SQLException
	{
		String sqlCommand = "SELECT * FROM Atendente WHERE idAtendente =?";
		ResultSet rs = null;
		try (Connection conn = ConnectionFactory.obtemConexao();)
    	{
    		PreparedStatement stm=null;
    		stm=conn.prepareStatement(sqlCommand);
    		stm.setInt(1,to.getId());
    		rs = stm.executeQuery();
  	      if(rs.next()){  
  	         to.setNome(rs.getString("nome"));
  	         to.setCpf(rs.getString("cpf"));
  	      }
    		stm.close();
    	}
	}
	
}