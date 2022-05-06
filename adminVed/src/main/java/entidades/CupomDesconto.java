package entidades;

public class CupomDesconto {


		private Integer id_cupom_desconto;
		private String descricao_desconto;
		private Integer porcentagem_desconto;
		
		public CupomDesconto(String descricao_desconto, Integer porcentagem_desconto) {
			super();
			this.descricao_desconto = descricao_desconto;
			this.porcentagem_desconto = porcentagem_desconto;
		}

		public Integer getId_cupom_desconto() {
			return id_cupom_desconto;
		}

		public void setId_cupom_desconto(Integer id_cupom_desconto) {
			this.id_cupom_desconto = id_cupom_desconto;
		}

		public String getDescricao_desconto() {
			return descricao_desconto;
		}

		public void setDescricao_desconto(String descricao_desconto) {
			this.descricao_desconto = descricao_desconto;
		}

		public Integer getPorcentagem_desconto() {
			return porcentagem_desconto;
		}

		public void setPorcentagem_desconto(Integer porcentagem_desconto) {
			this.porcentagem_desconto = porcentagem_desconto;
		}
		
		
		
		
		
		
	
	
	
}
