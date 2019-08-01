package br.com.franca.invictoweb.util;

public class Util {
	private static String mensagemErro;

	public static void setMensagemErro(Exception e) {
		while (e.getCause() != null) {
			e = (Exception) e.getCause();
		}
		mensagemErro = e.getMessage();
		/*if (mensagemErro.contains("viola restrição de chave estrangeira")) {
			mensagemErro = "Registro não pode ser excluido por possuir referências no sistema...";
		}*/
		
	}
	
	public static String getMensagemErro() {		
		return mensagemErro;
	}
}
