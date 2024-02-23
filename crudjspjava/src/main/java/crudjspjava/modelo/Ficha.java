package crudjspjava.modelo;

public class Ficha {
	
	private int id;
	private String nomePaciente;
	private String numCarteiraPlano;
	private String planoDeSaude;
	private String especialidade;
	
	public Ficha(String nomePaciente, String numCarteiraPlano, String planoDeSaude, String especialidade) {
		super();
		this.nomePaciente = nomePaciente;
		this.numCarteiraPlano = numCarteiraPlano;
		this.planoDeSaude = planoDeSaude;
		this.especialidade = especialidade;
	}
	
	public Ficha() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public String getNumCarteiraPlano() {
		return numCarteiraPlano;
	}

	public String getPlanoDeSaude() {
		return planoDeSaude;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

	public void setNumCarteiraPlano(String numCarteiraPlano) {
		this.numCarteiraPlano = numCarteiraPlano;
	}

	public void setPlanoDeSaude(String planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
}
