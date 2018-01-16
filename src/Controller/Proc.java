package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Proc {
	
	public void chamaProcesso(String caminhoProcesso, JFrame tela){
		if(!caminhoProcesso.equals("")) {
			try {
				Runtime.getRuntime().exec(caminhoProcesso);
				tela.dispose();
			} catch (IOException e) {
				//e.printStackTrace();
//				JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", 
//						JOptionPane.ERROR_MESSAGE);
				String erro = e.getMessage();
				if(erro.contains("740")){
					StringBuffer buffer = new StringBuffer();
					buffer.append("cmd.exe /c ");
					buffer.append(caminhoProcesso);
					try {
						Runtime.getRuntime().exec(buffer.toString());
						tela.dispose();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, e.getMessage(), "Erro, aplicação não encontrada",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}else {
			JOptionPane.showMessageDialog(null, "Campo vazio!!!","ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String procuraArquivo() {
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Arquivos executáveis (.exe)", "exe");
		String diretorioBase = System.getProperty("user.home")+"/Desktop";
		File dir = new File(diretorioBase);
		JFileChooser choose = new JFileChooser();
		choose.setCurrentDirectory(dir);
		choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
		choose.setAcceptAllFileFilterUsed(false);
		choose.addChoosableFileFilter(filtro);
		String caminhoArquivo = "";
		int retorno = choose.showOpenDialog(null);
		if(retorno == JFileChooser.APPROVE_OPTION) {
			caminhoArquivo = choose.getSelectedFile().getAbsolutePath();
			//caminhoArquivo = choose.getSelectedFile().getName();
		}
		return caminhoArquivo;
	}
	
	public void Sair(JFrame tela) {
		tela.dispose();
	}
	
}
