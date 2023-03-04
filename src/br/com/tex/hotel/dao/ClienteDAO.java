package br.com.tex.hotel.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tex.hotel.base.FactoryConnetion;
import br.com.tex.hotel.model.Cliente;

public class ClienteDAO {

	public void inserir(Cliente c) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();

		String sql = "INSERT INTO cliente (nome, cpf, dataNascimento,"
				+ " contato_id_contato, endereco_id_endereco, reserva_id_reserva)" 
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, c.getNome());
		statement.setString(2, c.getCpf());
		statement.setDate(3, Date.valueOf(c.getDataNascimento()));
		statement.setInt(4, c.getContato().getId());
		statement.setInt(5, c.getEndereco().getId());
		statement.setInt(6, c.getReservas().get(0).getId()); //precisa modificar.

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void alterar(Cliente c) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "UPDATE funcionario SET matricula= ?, nome= ?, cpf= ?, salario= ?, dataNascimento= ?,"
				+ " hotel_id_hotel= ?, endereco_id_endereco= ?, contato_id_contato= ? WHERE id_funcionario= ?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setString(1, c.getNome());
		statement.setString(2, c.getCpf());
		statement.setDate(3, Date.valueOf(c.getDataNascimento()));
		statement.setInt(4, c.getContato().getId());
		statement.setInt(5, c.getEndereco().getId());
		statement.setInt(6, c.getReservas().get(0).getId()); //precisa modificar.

		statement.execute();

		statement.close();
		conexao.close();
	}

	public void delete(Cliente c) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "DELETE FROM cliente WHERE id_cliente=?";

		PreparedStatement statement = conexao.prepareStatement(sql);

		statement.setInt(1, c.getId());
		statement.execute();

		statement.close();
		conexao.close();
	}

	public Cliente getById(Integer id) throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from cliente WHERE id_cliente=?";
		PreparedStatement statement = conexao.prepareStatement(sql);
		statement.setInt(1, id);

		ResultSet rs = statement.executeQuery();

		Cliente c = null;

		while (rs.next()) {
			c = new Cliente(rs.getString("nome"),
					rs.getString("cpf"),
					rs.getDate("dataNascimento").toLocalDate(),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")));
		}

		return c;
	}

	public List<Cliente> listAllFuncionario() throws SQLException {
		Connection conexao = FactoryConnetion.getConnection();
		String sql = "SELECT * from cliente";
		PreparedStatement statement = conexao.prepareStatement(sql);

		ResultSet rs = statement.executeQuery();

		List<Cliente> clientes= new ArrayList<>();

		while (rs.next()) {
			Cliente c = new Cliente(rs.getInt("id_cliente"),
					rs.getString("nome"), rs.getString("cpf"),
					rs.getDate("dataNascimento").toLocalDate(),
					new ContatoDAO().getById(rs.getInt("contato_id_contato")),
					new EnderecoDAO().getById(rs.getInt("endereco_id_endereco")));

			clientes.add(c);
		}

		return clientes;
	}
}