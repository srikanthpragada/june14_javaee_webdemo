package jsf;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

@ManagedBean
public class SendMailBean {

	private Part mailsFile;

	public Part getMailsFile() {
		return mailsFile;
	}

	public void setMailsFile(Part mailsFile) {
		this.mailsFile = mailsFile;
	}

	public void sendMails(ActionEvent evt) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(mailsFile.getInputStream()));

			while (true) {
				String line = br.readLine();
				if (line == null)
					break;
				System.out.println("Sending mail to : " + line);
			}

		} catch (Exception ex) {
            System.out.println(ex);
		}

	}

}
