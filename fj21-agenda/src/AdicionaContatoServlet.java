import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		Contato c = new Contato();
		c.setNome(req.getParameter("nome"));
		c.setEmail(req.getParameter("email"));
		c.setEndereco(req.getParameter("endereco"));

		String dataEmTexto = req.getParameter("dataNascimento");
		Calendar dataNascimento = Calendar.getInstance();

		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento.setTime(date);
			c.setDataNascimento(dataNascimento);
		} catch (ParseException e) {
			pw.println("Erro de conversão de data");
			return;
		}

		ContatoDao dao = new ContatoDao();
		dao.adiciona(c);

		pw.println("<html><body>");
		pw.println("Contato " + c.getNome() + " adicionado com sucesso");
		pw.println("</body></html>");
	}
}
