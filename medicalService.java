	package java2Asignment1;

    /**
     * 
     * @author Kathiresan
     *
     */
    public class medicalService extends resource {
        
        /** attributes, refer to class diagram given */
        private int patientCapacity;
        
    /**
     * Constructor to the MedicalServices class
     * inherit resourceID, resourceName, cost constructor from superclass Resource. 
     * @param resourceID the resourceID of the medical service to be set
     * @param resourceName the resourceName of the medical service to be set
     * @param cost the cost of the medical service to be set
     * @param patientCapacity the patient capacity of the medical service to set.
     */
        public medicalService(String resourceID, String resourceName, int cost, int patientCapacity) {
            super(resourceID, resourceName, cost);
            setPatientCapacity(patientCapacity);
        }
        
        /**
         * Return the number of patient capacity of the medical service can hold.
         * @return the patient capacity of the medical service.
         */
        public int getPatientCapacity() {
            return patientCapacity;
        }

        /**
         * Set the number of patient capacity of the medical service
         *use it to reduce the number of infected patient.
         * @param patientCapacity the patient capacity integer to be set.
         */
        public void setPatientCapacity(int patientCapacity) {
            this.patientCapacity = patientCapacity;
        }

        /**
        * toString() method returns the MedicalServices detail as a String
        * @return the MedicalServices information
        */
        @Override
        public String toString() {
            return super.toString() + "MedicalServices{" + "patientCapacity=" + patientCapacity + '}';
        }



    /**
     * method name inherit from Resource
     * Reduce the number of infected patient by increasing the number of medical service
     * @param site the site to be set.
     */
        public void applyTo(site site) {
            
            //patient counter
            int numOfPatient = (site.getNumInfected() -this.getPatientCapacity());
            
            //if medical center can hold more then the current patient, patient equal to zero.
            if(numOfPatient>0)
            {
                site.setNumInfected (numOfPatient);
            }else{
                site.setNumInfected (0);
           }  
        }
   }
