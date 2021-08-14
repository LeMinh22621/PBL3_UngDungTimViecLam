package BLL;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DAL.DAL;
import DTO.Account;
import DTO.Category_job;
import DTO.JobSeeker;
import DTO.Post;
import DTO.Profile;

public class BLL_GUEST {
	private static BLL_GUEST Instance;

	public static BLL_GUEST getInstance() {
		if (Instance == null)
			Instance = new BLL_GUEST();
		return Instance;
	}

	public List<Post> getListPostByNameAndAddress_BLL_GUEST(String name, String address) {
		try {
			List<Post> list = new ArrayList<Post>();
			for (Post i : DAL.getInstance().getListPost_DAL()) {
				if (i.getCATEGORY_JOB().getCATEGORY_JOB_NAME().contains(name) && i.getCITY().contains(address)&& i.getSTATUS() == true) {
					list.add(i);
				}
			}
			return list;
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public List<JobSeeker> GetlistJobSeeker_BLL_GUEST(String name, String address) {
		try {
			List<JobSeeker> list = new ArrayList<JobSeeker>();
			for (JobSeeker i : DAL.getInstance().getAllJobSeeker_DAL()) {
				if (i.getPROFESSIONAL().contains(name) && i.getPROFILE().getCITY().contains(address)) {
					list.add(i);
				}
			}
			return list;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;

	}

	public Account getAccountByID_BLL_GUEST(String id_ACCOUNT) {
		// TODO Auto-generated method stub
		try {
			return DAL.getInstance().getAccountByID_DAL(id_ACCOUNT);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public Profile getProfileByID_BLL_GUEST(String id_PROFILE) {
		// TODO Auto-generated method stub
		try {
			DAL.getInstance().getProfileByID_DAL(id_PROFILE);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public List<String> getListPROFESSIONAL_BLL_GUEST() {
		try {
			return DAL.getInstance().getListPROFESSIONAL_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public List<String> getListAddressJobseeker_BLL_GUEST() {

		try {
			return DAL.getInstance().getListAddressJobSeeker_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public List<String> getListJobName_BLL_GUEST() {
		try {
			return DAL.getInstance().getListJobName_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public List<String> getListAddressPost_BLL_GUEST() {
		try {
			return DAL.getInstance().getListAddressPost_DAL();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public Profile getProfileByID_Account_BLL_GUEST(String id_ACCOUNT) {

		try {
			return DAL.getInstance().getEmployerByIDAccount_DAL(id_ACCOUNT).getPROFILE();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public JobSeeker getJobseekerByID_Profile_BLL_GUEST(String id_PROFILE) {
		try {
			for (JobSeeker i : DAL.getInstance().getAllJobSeeker_DAL()) {
				if (i.getPROFILE().getID_PROFILE().equals(id_PROFILE)) {
					return i;
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public Profile getProfileJobByID_Account_BLL_GUEST(String id_ACCOUNT) {
		try {
			return DAL.getInstance().getJobSeekerByIDAccount_DAL(id_ACCOUNT).getPROFILE();
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public int SelectLastRowPost_BLL() {
		int result = -1;
		try {
			String id = DAL.getInstance().SelectLastRowPost_DAL("P");
			String num;
			if (id == null) {
				num = "0";
			} else
				num = id.replaceAll("P", "");
			result = Integer.parseInt(num);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}

		return result;
	}

	public boolean Post_BLL_GUEST(String iD_Acc, String jobname, String companyname, String city, String salary,
			String descrip, String labor, String category, String date) {
		if (jobname.length() != 0 && companyname.length() != 0 && city.length() != 0 && salary.length() != 0) {
			try {
				int idp = SelectLastRowPost_BLL() + 1;
				String IDP = "P" + idp;
				DAL.getInstance().Post_DAL(IDP, iD_Acc, jobname, companyname, city, salary, descrip, labor, category, date);
				JOptionPane.showMessageDialog(null, "Post success!");
				return true;
			} catch (ClassNotFoundException | SQLException e) {
				JOptionPane.showMessageDialog(null, "Post failed");
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, "Please full fill");
			return false;
		}
	}

	public List<String> getListCategoryJobName_BLL_GUEST() {
		List<String> list = new ArrayList<String>();
		try {
			for (Category_job i : DAL.getInstance().getListCategory_job_DAL()) {
				list.add(i.getCATEGORY_JOB_NAME());
			}
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
	}

	public List<Post> getListPostByIDEmployer_BLL_GUEST(String iDEmployer) {
		// TODO Auto-generated method stub
		List<Post> list = new ArrayList<Post>();
		try {
			for (Post i : DAL.getInstance().getListPost_DAL()) {
				if (i.getEMPLOYER().getID_EMPLOYER().equals(iDEmployer)) {
					list.add(i);
				}
			}
		} catch (ClassNotFoundException | SQLException | ParseException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return list;
	}

	public String getIDEMployerByIDAccount_BLL_GUEST(String id_ACCOUNT) {
		// TODO Auto-generated method stub
		try {
			return DAL.getInstance().getEmployerByIDAccount_DAL(id_ACCOUNT).getID_EMPLOYER();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		return null;
	}

	public void DeletePostByID_BLL_GUEST(String iD) {
		// TODO Auto-generated method stub
		try {
			DAL.getInstance().DeletePostByID_DAL(iD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public List<JobSeeker> SortJobseeker_BLL(String item, String name, String address) {
		// TODO Auto-generated method stub
		List<JobSeeker> list = new ArrayList<JobSeeker>();
		list = GetlistJobSeeker_BLL_GUEST(name, address);
		switch (item) {
		case "JOBSEEKER_NAME": {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).getPROFILE().getNAME().compareTo(list.get(j).getPROFILE().getNAME()) >= 0) {
						java.util.Collections.swap(list, i, j);
					}
				}
			}
			break;
		}
		case "AGE": {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).getAGE() > list.get(j).getAGE()) {
						java.util.Collections.swap(list, i, j);
					}
				}
			}
			break;
		}
		}
		return list;
	}

	public List<Post> getListSort_BLL_GUEST(String item, String name, String address) {
		// TODO Auto-generated method stub
		List<Post> list = new ArrayList<Post>();
		list = getListPostByNameAndAddress_BLL_GUEST(name, address);
		switch (item) {
		case "CATEGORY_JOB_NAME": {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).getCATEGORY_JOB().getCATEGORY_JOB_NAME()
							.compareTo(list.get(j).getCATEGORY_JOB().getCATEGORY_JOB_NAME()) >= 0) {
						java.util.Collections.swap(list, i, j);
					}
				}
			}
			break;
		}
		case "COMPANY_NAME": {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).getCOMPANY_NAME().compareTo(list.get(j).getCOMPANY_NAME()) >= 0) {
						java.util.Collections.swap(list, i, j);
					}
				}
			}
			break;
		}
		case "SALARY": {
			for (int i = 0; i < list.size() - 1; i++) {
				for (int j = i + 1; j < list.size(); j++) {
					if (list.get(i).getSALARY() > list.get(j).getSALARY()) {
						java.util.Collections.swap(list, i, j);
					}
				}
			}
			break;
		}
		}
		return list;
	}

	public List<String> getListCVByID_Jobseeker_BLL_GUEST(String id_JOBSEEKER) {
		// TODO Auto-generated method stub
		try {
			return DAL.getInstance().getListCVByID_Jobseeker_DAL(id_JOBSEEKER);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
			return null;
		}
	}

	public void CancelAppliedsI_BLL_GUEST(String ID) {
		// TODO Auto-generated method stub
		try {
			DAL.getInstance().CancelAppliedsI_DAL(ID);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
