package DTO;

public class Category_job 
{

		private String ID_CATEGORY_JOB ;
		private String CATEGORY_JOB_NAME;
		
		public String getID_CATEGORY_JOB() {
			return ID_CATEGORY_JOB;
		}
    
		public void setID_CATEGORY_JOB(String  id_category_job) {
			this.ID_CATEGORY_JOB =  id_category_job;
		}
		
		public String getCATEGORY_JOB_NAME() {
			return CATEGORY_JOB_NAME;
		}

		public void setCATEGORY_JOB_NAME(String category_job_name) {
			this.CATEGORY_JOB_NAME = category_job_name;
		}
}