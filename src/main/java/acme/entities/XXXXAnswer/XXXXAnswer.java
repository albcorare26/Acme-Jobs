
package acme.entities.XXXXAnswer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import acme.entities.applications.Application;
import acme.framework.entities.DomainEntity;
import acme.framework.helpers.PasswordHelper;
import acme.framework.helpers.StringHelper;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class XXXXAnswer extends DomainEntity {

	private static final long	serialVersionUID	= 1L;

	@NotBlank
	@Column(length = 1024)
	private String				description;

	private String				moreInfo;

	//	@Pattern(regexp = "^(?=.*[A-Za-z].*){2,}(?=.*\\d.*){2,}(?=.*[\\p{P}].*){2,}[A-Za-z\\d\\p{P}]{8,}$")
	@Length(min = 5)
	private String				password;


	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		assert password == null || password.equals("") || !PasswordHelper.isEncoded(password);

		if (!StringHelper.isBlank(password)) {
			this.password = PasswordHelper.encode(password);
		}
	}


	@NotNull
	@Valid
	@OneToOne
	private Application application;

}
