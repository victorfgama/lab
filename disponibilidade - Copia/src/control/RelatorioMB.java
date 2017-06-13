package control;



import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import persistence.ReportDao;




@ManagedBean(name = "relatorioMB")
@ViewScoped
public class RelatorioMB {

	public void geraRelatorio(String usuario) throws SQLException{
		String jasper = "/jasper/relatorio.jasper";
		jasper = jasper.replaceFirst("/", "");
		ReportDao rDao = new ReportDao();
		try {
			ResultSet rs = rDao.retornaQuery(usuario);
			//Aqui começa a geração de Relatorio
			
			JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
			JasperPrint jPrint = JasperFillManager.fillReport(
					jasper, new HashMap<String, Object>(), jrRS);
			File arquivoSaida = new File("/pdf/relatorio.pdf"); 
			JasperExportManager.exportReportToPdfFile(jPrint, arquivoSaida.getAbsolutePath());
			Desktop desktop = Desktop.getDesktop();
			desktop.open(arquivoSaida);
		} catch (SQLException e) {
			// TODO Auto-generated catch block			
			e.printStackTrace();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
