package com.example.yatimjadid.Models;

import java.io.Serializable;
import java.util.List;

import io.realm.RealmObject;

public class AllResolutionModels extends RealmObject implements Serializable  {

    String id = "";
    String yatimParentsSelected = "";
    String refugeeSelected = "";
    String motherName = "";
    String motherDateOfBirth = "";
    String maritalStatus = "";
    String educationalLevel = "";
    String universityEducation = "";
    String specialization = "";
    String graduationYear = "";
    String average = "";
    String parentsName = "";
    String parentsId = "";
    String parentsDateOfBirth = "";
    String relationshipWithTheOrphan = "";


    String memberNumber = "";
    String housingTypeSpinner = "";
    String propertySpinner = "";
    String roofType = "";
    String wallType = "";
    String floorType = "";
    String windowsCase = "";
    String doorsCase = "";
    String kitchenCondition = "";
    String bathroomCondition = "";
    String housingConditionInGeneral = "";
    String improvementNeeds = "";
    String furnitureNeeds = "";
    String hardwareNeeds = "";
    String lightingSelected = "";
    String ventilationSelected = "";
    String electricitySelected = "";
    String waterNetworkSelected = "";
    String alternativeElectricitySelected = "";
    String sewageSelected = "";
    String roomsNumber = "";
    String space = "";
    String peopleForRooms = "";
    String houseLocation = "";

    String domesticWaterSource = "";
    String sourceOfDrinkingCookingWater = "";
    String numberOfMunicipalDaysWaterArrived = "";
    String doHeNeedAnyOfTheFollowing = "";
    String conditionOfCleanlinessArrangement = "";
    String tankCapacity = "";
    String tankCapacityNumber = "";
    String drinkingWaterCapacity = "";
    String drinkingWaterCapacityNum = "";
    String guardianOfTheOrphanSelected = "";
    String familyDebtsSelected = "";
    String accumulatedCollegeSelected = "";
    String workNature = "";
    String averageIncome = "";

    List<FamilyMembersModel> familyMembersList = null;




//    String memberName;
//    String memberDateOfBirth;
//    String memberRelationshipWithYatim;
//    String memberGender;
//    String memberClassroom;
//    String memberSpecialization;
//    String memberGraduationYear;
//    String memberAverage;
//    String memberFamilySituation;
//    String memberHealthStatus;
//    String memberGuaranteed;
//
//    String YatimPhotoUri = "";
//    String yatimName = "";
//    String yatimDateOfBirth = "";
//    String yatimGenderSelected = "";
//    String fatherDeathDate = "";
//    String causeOfDeath = "";
//    String ageAtDeath = "";
//    String fatherJob = "";
//    String previousIncome = "";
//    String inheritanceOrPension = "";
//    String conservation = "";
//    String addressDetails = "";
//    String mobileNumber = "";
//
//    String height = "";
//    String weight = "";
//    String needAnyOfTheFollowing = "";
//    String healthConditionSelected = "";
//    String hasALockSelected = "";
//    String natureOfCase = "";
//    String statusSinceSelected = "";
//    String diseaseName = "";
//    String yatimSpecialNeeds = "";
//    String handicappedNeeds = "";
//    String mentalDisorderType = "";
//    String teethHealth = "";
//    String psychologicalState = "";
//    String yatimNeeds = "";
//
//    String educationalStatusSelected = "";
//    String reasonForNotJoining = "";
//    String stage = "";
//    String schoolType = "";
//    String schoolUniversityName = "";
//    String educationAddress = "";
//    String periodSelected = "";
//    String gradeLevel = "";
//    String specialist = "";
//    String educationalAvarge = "";
//    String ConsistentSelected = "";
//    String nonCompliance = "";
//    String reachSchool = "";
//    String readWriteSelected = "";
//    String levelOfAcademicAchievement = "";
//    String educationalSpecialNeeds = "";
//    String materialsNeedStrengthening = "";
//
//    String talentSelected = "";
//    String interestsSelected = "";
//    String skillsSelected = "";
//    String wishSelected = "";
//    String responsibilitiesSelected = "";
//    String favoriteFood = "";
//    String futureWish = "";
//    String pet = "";
//    String immediateNeeds = "";
//

    public String getMemberNumber() {
        return memberNumber;
    }

    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYatimParentsSelected() {
        return yatimParentsSelected;
    }

    public void setYatimParentsSelected(String yatimParentsSelected) {
        this.yatimParentsSelected = yatimParentsSelected;
    }

    public String getRefugeeSelected() {
        return refugeeSelected;
    }

    public void setRefugeeSelected(String refugeeSelected) {
        this.refugeeSelected = refugeeSelected;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getMotherDateOfBirth() {
        return motherDateOfBirth;
    }

    public void setMotherDateOfBirth(String motherDateOfBirth) {
        this.motherDateOfBirth = motherDateOfBirth;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
    }

    public String getUniversityEducation() {
        return universityEducation;
    }

    public void setUniversityEducation(String universityEducation) {
        this.universityEducation = universityEducation;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average;
    }

    public String getParentsName() {
        return parentsName;
    }

    public void setParentsName(String parentsName) {
        this.parentsName = parentsName;
    }

    public String getParentsId() {
        return parentsId;
    }

    public void setParentsId(String parentsId) {
        this.parentsId = parentsId;
    }

    public String getParentsDateOfBirth() {
        return parentsDateOfBirth;
    }

    public void setParentsDateOfBirth(String parentsDateOfBirth) {
        this.parentsDateOfBirth = parentsDateOfBirth;
    }

    public String getRelationshipWithTheOrphan() {
        return relationshipWithTheOrphan;
    }

    public void setRelationshipWithTheOrphan(String relationshipWithTheOrphan) {
        this.relationshipWithTheOrphan = relationshipWithTheOrphan;
    }

    public String getHousingTypeSpinner() {
        return housingTypeSpinner;
    }

    public void setHousingTypeSpinner(String housingTypeSpinner) {
        this.housingTypeSpinner = housingTypeSpinner;
    }

    public String getPropertySpinner() {
        return propertySpinner;
    }

    public void setPropertySpinner(String propertySpinner) {
        this.propertySpinner = propertySpinner;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public String getWallType() {
        return wallType;
    }

    public void setWallType(String wallType) {
        this.wallType = wallType;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public String getWindowsCase() {
        return windowsCase;
    }

    public void setWindowsCase(String windowsCase) {
        this.windowsCase = windowsCase;
    }

    public String getDoorsCase() {
        return doorsCase;
    }

    public void setDoorsCase(String doorsCase) {
        this.doorsCase = doorsCase;
    }

    public String getKitchenCondition() {
        return kitchenCondition;
    }

    public void setKitchenCondition(String kitchenCondition) {
        this.kitchenCondition = kitchenCondition;
    }

    public String getBathroomCondition() {
        return bathroomCondition;
    }

    public void setBathroomCondition(String bathroomCondition) {
        this.bathroomCondition = bathroomCondition;
    }

    public String getHousingConditionInGeneral() {
        return housingConditionInGeneral;
    }

    public void setHousingConditionInGeneral(String housingConditionInGeneral) {
        this.housingConditionInGeneral = housingConditionInGeneral;
    }

    public String getImprovementNeeds() {
        return improvementNeeds;
    }

    public void setImprovementNeeds(String improvementNeeds) {
        this.improvementNeeds = improvementNeeds;
    }

    public String getFurnitureNeeds() {
        return furnitureNeeds;
    }

    public void setFurnitureNeeds(String furnitureNeeds) {
        this.furnitureNeeds = furnitureNeeds;
    }

    public String getHardwareNeeds() {
        return hardwareNeeds;
    }

    public void setHardwareNeeds(String hardwareNeeds) {
        this.hardwareNeeds = hardwareNeeds;
    }

    public String getLightingSelected() {
        return lightingSelected;
    }

    public void setLightingSelected(String lightingSelected) {
        this.lightingSelected = lightingSelected;
    }

    public String getVentilationSelected() {
        return ventilationSelected;
    }

    public void setVentilationSelected(String ventilationSelected) {
        this.ventilationSelected = ventilationSelected;
    }

    public String getElectricitySelected() {
        return electricitySelected;
    }

    public void setElectricitySelected(String electricitySelected) {
        this.electricitySelected = electricitySelected;
    }

    public String getWaterNetworkSelected() {
        return waterNetworkSelected;
    }

    public void setWaterNetworkSelected(String waterNetworkSelected) {
        this.waterNetworkSelected = waterNetworkSelected;
    }

    public String getAlternativeElectricitySelected() {
        return alternativeElectricitySelected;
    }

    public void setAlternativeElectricitySelected(String alternativeElectricitySelected) {
        this.alternativeElectricitySelected = alternativeElectricitySelected;
    }

    public String getSewageSelected() {
        return sewageSelected;
    }

    public void setSewageSelected(String sewageSelected) {
        this.sewageSelected = sewageSelected;
    }

    public String getRoomsNumber() {
        return roomsNumber;
    }

    public void setRoomsNumber(String roomsNumber) {
        this.roomsNumber = roomsNumber;
    }

    public String getSpace() {
        return space;
    }

    public void setSpace(String space) {
        this.space = space;
    }

    public String getPeopleForRooms() {
        return peopleForRooms;
    }

    public void setPeopleForRooms(String peopleForRooms) {
        this.peopleForRooms = peopleForRooms;
    }

    public String getHouseLocation() {
        return houseLocation;
    }

    public void setHouseLocation(String houseLocation) {
        this.houseLocation = houseLocation;
    }

    public String getDomesticWaterSource() {
        return domesticWaterSource;
    }

    public void setDomesticWaterSource(String domesticWaterSource) {
        this.domesticWaterSource = domesticWaterSource;
    }

    public String getSourceOfDrinkingCookingWater() {
        return sourceOfDrinkingCookingWater;
    }

    public void setSourceOfDrinkingCookingWater(String sourceOfDrinkingCookingWater) {
        this.sourceOfDrinkingCookingWater = sourceOfDrinkingCookingWater;
    }

    public String getNumberOfMunicipalDaysWaterArrived() {
        return numberOfMunicipalDaysWaterArrived;
    }

    public void setNumberOfMunicipalDaysWaterArrived(String numberOfMunicipalDaysWaterArrived) {
        this.numberOfMunicipalDaysWaterArrived = numberOfMunicipalDaysWaterArrived;
    }

    public String getDoHeNeedAnyOfTheFollowing() {
        return doHeNeedAnyOfTheFollowing;
    }

    public void setDoHeNeedAnyOfTheFollowing(String doHeNeedAnyOfTheFollowing) {
        this.doHeNeedAnyOfTheFollowing = doHeNeedAnyOfTheFollowing;
    }

    public String getConditionOfCleanlinessArrangement() {
        return conditionOfCleanlinessArrangement;
    }

    public void setConditionOfCleanlinessArrangement(String conditionOfCleanlinessArrangement) {
        this.conditionOfCleanlinessArrangement = conditionOfCleanlinessArrangement;
    }

    public String getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(String tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public String getTankCapacityNumber() {
        return tankCapacityNumber;
    }

    public void setTankCapacityNumber(String tankCapacityNumber) {
        this.tankCapacityNumber = tankCapacityNumber;
    }

    public String getDrinkingWaterCapacity() {
        return drinkingWaterCapacity;
    }

    public void setDrinkingWaterCapacity(String drinkingWaterCapacity) {
        this.drinkingWaterCapacity = drinkingWaterCapacity;
    }

    public String getDrinkingWaterCapacityNum() {
        return drinkingWaterCapacityNum;
    }

    public void setDrinkingWaterCapacityNum(String drinkingWaterCapacityNum) {
        this.drinkingWaterCapacityNum = drinkingWaterCapacityNum;
    }

    public String getGuardianOfTheOrphanSelected() {
        return guardianOfTheOrphanSelected;
    }

    public void setGuardianOfTheOrphanSelected(String guardianOfTheOrphanSelected) {
        this.guardianOfTheOrphanSelected = guardianOfTheOrphanSelected;
    }

    public String getFamilyDebtsSelected() {
        return familyDebtsSelected;
    }

    public void setFamilyDebtsSelected(String familyDebtsSelected) {
        this.familyDebtsSelected = familyDebtsSelected;
    }

    public String getAccumulatedCollegeSelected() {
        return accumulatedCollegeSelected;
    }

    public void setAccumulatedCollegeSelected(String accumulatedCollegeSelected) {
        this.accumulatedCollegeSelected = accumulatedCollegeSelected;
    }

    public String getWorkNature() {
        return workNature;
    }

    public void setWorkNature(String workNature) {
        this.workNature = workNature;
    }

    public String getAverageIncome() {
        return averageIncome;
    }

    public void setAverageIncome(String averageIncome) {
        this.averageIncome = averageIncome;
    }

//    public String getMemberName() {
//        return memberName;
//    }
//
//    public void setMemberName(String memberName) {
//        this.memberName = memberName;
//    }
//
//    public String getMemberDateOfBirth() {
//        return memberDateOfBirth;
//    }
//
//    public void setMemberDateOfBirth(String memberDateOfBirth) {
//        this.memberDateOfBirth = memberDateOfBirth;
//    }
//
//    public String getMemberRelationshipWithYatim() {
//        return memberRelationshipWithYatim;
//    }
//
//    public void setMemberRelationshipWithYatim(String memberRelationshipWithYatim) {
//        this.memberRelationshipWithYatim = memberRelationshipWithYatim;
//    }

//    public String getMemberGender() {
//        return memberGender;
//    }
//
//    public void setMemberGender(String memberGender) {
//        this.memberGender = memberGender;
//    }
//
//    public String getMemberClassroom() {
//        return memberClassroom;
//    }
//
//    public void setMemberClassroom(String memberClassroom) {
//        this.memberClassroom = memberClassroom;
//    }
//
//    public String getMemberSpecialization() {
//        return memberSpecialization;
//    }
//
//    public void setMemberSpecialization(String memberSpecialization) {
//        this.memberSpecialization = memberSpecialization;
//    }
//
//    public String getMemberGraduationYear() {
//        return memberGraduationYear;
//    }
//
//    public void setMemberGraduationYear(String memberGraduationYear) {
//        this.memberGraduationYear = memberGraduationYear;
//    }
//
//    public String getMemberAverage() {
//        return memberAverage;
//    }
//
//    public void setMemberAverage(String memberAverage) {
//        this.memberAverage = memberAverage;
//    }
//
//    public String getMemberFamilySituation() {
//        return memberFamilySituation;
//    }

//    public void setMemberFamilySituation(String memberFamilySituation) {
//        this.memberFamilySituation = memberFamilySituation;
//    }
//
//    public String getMemberHealthStatus() {
//        return memberHealthStatus;
//    }
//
//    public void setMemberHealthStatus(String memberHealthStatus) {
//        this.memberHealthStatus = memberHealthStatus;
//    }
//
//    public String getMemberGuaranteed() {
//        return memberGuaranteed;
//    }
//
//    public void setMemberGuaranteed(String memberGuaranteed) {
//        this.memberGuaranteed = memberGuaranteed;
//    }

//    public String getYatimPhotoUri() {
//        return YatimPhotoUri;
//    }
//
//    public void setYatimPhotoUri(String yatimPhotoUri) {
//        this.YatimPhotoUri = yatimPhotoUri;
//    }
//
//    public String getYatimName() {
//        return yatimName;
//    }
//
//    public void setYatimName(String yatimName) {
//        this.yatimName = yatimName;
//    }
//
//    public String getYatimDateOfBirth() {
//        return yatimDateOfBirth;
//    }
//
//    public void setYatimDateOfBirth(String yatimDateOfBirth) {
//        this.yatimDateOfBirth = yatimDateOfBirth;
//    }
//
//    public String getYatimGenderSelected() {
//        return yatimGenderSelected;
//    }
//
//    public void setYatimGenderSelected(String yatimGenderSelected) {
//        this.yatimGenderSelected = yatimGenderSelected;
//    }
//
//    public String getFatherDeathDate() {
//        return fatherDeathDate;
//    }
//
//    public void setFatherDeathDate(String fatherDeathDate) {
//        this.fatherDeathDate = fatherDeathDate;
//    }
//
//    public String getCauseOfDeath() {
//        return causeOfDeath;
//    }
//
//    public void setCauseOfDeath(String causeOfDeath) {
//        this.causeOfDeath = causeOfDeath;
//    }
//
//    public String getAgeAtDeath() {
//        return ageAtDeath;
//    }
//
//    public void setAgeAtDeath(String ageAtDeath) {
//        this.ageAtDeath = ageAtDeath;
//    }
//
//    public String getFatherJob() {
//        return fatherJob;
//    }
//
//    public void setFatherJob(String fatherJob) {
//        this.fatherJob = fatherJob;
//    }
//
//    public String getPreviousIncome() {
//        return previousIncome;
//    }
//
//    public void setPreviousIncome(String previousIncome) {
//        this.previousIncome = previousIncome;
//    }
//
//    public String getInheritanceOrPension() {
//        return inheritanceOrPension;
//    }
//
//    public void setInheritanceOrPension(String inheritanceOrPension) {
//        this.inheritanceOrPension = inheritanceOrPension;
//    }
//
//    public String getConservation() {
//        return conservation;
//    }
//
//    public void setConservation(String conservation) {
//        this.conservation = conservation;
//    }
//
//    public String getAddressDetails() {
//        return addressDetails;
//    }
//
//    public void setAddressDetails(String addressDetails) {
//        this.addressDetails = addressDetails;
//    }
//
//    public String getMobileNumber() {
//        return mobileNumber;
//    }
//
//    public void setMobileNumber(String mobileNumber) {
//        this.mobileNumber = mobileNumber;
//    }
//
//    public String getHeight() {
//        return height;
//    }
//
//    public void setHeight(String height) {
//        this.height = height;
//    }
//
//    public String getWeight() {
//        return weight;
//    }
//
//    public void setWeight(String weight) {
//        this.weight = weight;
//    }
//
//    public String getNeedAnyOfTheFollowing() {
//        return needAnyOfTheFollowing;
//    }
//
//    public void setNeedAnyOfTheFollowing(String needAnyOfTheFollowing) {
//        this.needAnyOfTheFollowing = needAnyOfTheFollowing;
//    }
//
//    public String getHealthConditionSelected() {
//        return healthConditionSelected;
//    }
//
//    public void setHealthConditionSelected(String healthConditionSelected) {
//        this.healthConditionSelected = healthConditionSelected;
//    }
//
//    public String getHasALockSelected() {
//        return hasALockSelected;
//    }
//
//    public void setHasALockSelected(String hasALockSelected) {
//        this.hasALockSelected = hasALockSelected;
//    }
//
//    public String getNatureOfCase() {
//        return natureOfCase;
//    }
//
//    public void setNatureOfCase(String natureOfCase) {
//        this.natureOfCase = natureOfCase;
//    }
//
//    public String getStatusSinceSelected() {
//        return statusSinceSelected;
//    }
//
//    public void setStatusSinceSelected(String statusSinceSelected) {
//        this.statusSinceSelected = statusSinceSelected;
//    }
//
//    public String getDiseaseName() {
//        return diseaseName;
//    }
//
//    public void setDiseaseName(String diseaseName) {
//        this.diseaseName = diseaseName;
//    }
//
//    public String getYatimSpecialNeeds() {
//        return yatimSpecialNeeds;
//    }
//
//    public void setYatimSpecialNeeds(String yatimSpecialNeeds) {
//        this.yatimSpecialNeeds = yatimSpecialNeeds;
//    }
//
//    public String getHandicappedNeeds() {
//        return handicappedNeeds;
//    }
//
//    public void setHandicappedNeeds(String handicappedNeeds) {
//        this.handicappedNeeds = handicappedNeeds;
//    }
//
//    public String getMentalDisorderType() {
//        return mentalDisorderType;
//    }
//
//    public void setMentalDisorderType(String mentalDisorderType) {
//        this.mentalDisorderType = mentalDisorderType;
//    }
//
//    public String getTeethHealth() {
//        return teethHealth;
//    }
//
//    public void setTeethHealth(String teethHealth) {
//        this.teethHealth = teethHealth;
//    }
//
//    public String getPsychologicalState() {
//        return psychologicalState;
//    }
//
//    public void setPsychologicalState(String psychologicalState) {
//        this.psychologicalState = psychologicalState;
//    }
//
//    public String getYatimNeeds() {
//        return yatimNeeds;
//    }
//
//    public void setYatimNeeds(String yatimNeeds) {
//        this.yatimNeeds = yatimNeeds;
//    }
//
//    public String getEducationalStatusSelected() {
//        return educationalStatusSelected;
//    }
//
//    public void setEducationalStatusSelected(String educationalStatusSelected) {
//        this.educationalStatusSelected = educationalStatusSelected;
//    }
//
//    public String getReasonForNotJoining() {
//        return reasonForNotJoining;
//    }
//
//    public void setReasonForNotJoining(String reasonForNotJoining) {
//        this.reasonForNotJoining = reasonForNotJoining;
//    }
//
//    public String getStage() {
//        return stage;
//    }
//
//    public void setStage(String stage) {
//        this.stage = stage;
//    }
//
//    public String getSchoolType() {
//        return schoolType;
//    }
//
//    public void setSchoolType(String schoolType) {
//        this.schoolType = schoolType;
//    }
//
//    public String getSchoolUniversityName() {
//        return schoolUniversityName;
//    }
//
//    public void setSchoolUniversityName(String schoolUniversityName) {
//        this.schoolUniversityName = schoolUniversityName;
//    }
//
//    public String getEducationAddress() {
//        return educationAddress;
//    }
//
//    public void setEducationAddress(String educationAddress) {
//        this.educationAddress = educationAddress;
//    }
//
//    public String getPeriodSelected() {
//        return periodSelected;
//    }
//
//    public void setPeriodSelected(String periodSelected) {
//        this.periodSelected = periodSelected;
//    }
//
//    public String getGradeLevel() {
//        return gradeLevel;
//    }
//
//    public void setGradeLevel(String gradeLevel) {
//        this.gradeLevel = gradeLevel;
//    }
//
//    public String getSpecialist() {
//        return specialist;
//    }
//
//    public void setSpecialist(String specialist) {
//        this.specialist = specialist;
//    }
//
//    public String getEducationalAvarge() {
//        return educationalAvarge;
//    }
//
//    public void setEducationalAvarge(String educationalAvarge) {
//        this.educationalAvarge = educationalAvarge;
//    }
//
//    public String getConsistentSelected() {
//        return ConsistentSelected;
//    }
//
//    public void setConsistentSelected(String consistentSelected) {
//        ConsistentSelected = consistentSelected;
//    }
//
//    public String getNonCompliance() {
//        return nonCompliance;
//    }
//
//    public void setNonCompliance(String nonCompliance) {
//        this.nonCompliance = nonCompliance;
//    }
//
//    public String getReachSchool() {
//        return reachSchool;
//    }
//
//    public void setReachSchool(String reachSchool) {
//        this.reachSchool = reachSchool;
//    }
//
//    public String getReadWriteSelected() {
//        return readWriteSelected;
//    }
//
//    public void setReadWriteSelected(String readWriteSelected) {
//        this.readWriteSelected = readWriteSelected;
//    }
//
//    public String getLevelOfAcademicAchievement() {
//        return levelOfAcademicAchievement;
//    }
//
//    public void setLevelOfAcademicAchievement(String levelOfAcademicAchievement) {
//        this.levelOfAcademicAchievement = levelOfAcademicAchievement;
//    }
//
//    public String getEducationalSpecialNeeds() {
//        return educationalSpecialNeeds;
//    }
//
//    public void setEducationalSpecialNeeds(String educationalSpecialNeeds) {
//        this.educationalSpecialNeeds = educationalSpecialNeeds;
//    }
//
//    public String getMaterialsNeedStrengthening() {
//        return materialsNeedStrengthening;
//    }
//
//    public void setMaterialsNeedStrengthening(String materialsNeedStrengthening) {
//        this.materialsNeedStrengthening = materialsNeedStrengthening;
//    }
//
//    public String getTalentSelected() {
//        return talentSelected;
//    }
//
//    public void setTalentSelected(String talentSelected) {
//        this.talentSelected = talentSelected;
//    }
//
//    public String getInterestsSelected() {
//        return interestsSelected;
//    }
//
//    public void setInterestsSelected(String interestsSelected) {
//        this.interestsSelected = interestsSelected;
//    }
//
//    public String getSkillsSelected() {
//        return skillsSelected;
//    }
//
//    public void setSkillsSelected(String skillsSelected) {
//        this.skillsSelected = skillsSelected;
//    }
//
//    public String getWishSelected() {
//        return wishSelected;
//    }
//
//    public void setWishSelected(String wishSelected) {
//        this.wishSelected = wishSelected;
//    }
//
//    public String getResponsibilitiesSelected() {
//        return responsibilitiesSelected;
//    }
//
//    public void setResponsibilitiesSelected(String responsibilitiesSelected) {
//        this.responsibilitiesSelected = responsibilitiesSelected;
//    }
//
//    public String getFavoriteFood() {
//        return favoriteFood;
//    }
//
//    public void setFavoriteFood(String favoriteFood) {
//        this.favoriteFood = favoriteFood;
//    }
//
//    public String getFutureWish() {
//        return futureWish;
//    }
//
//    public void setFutureWish(String futureWish) {
//        this.futureWish = futureWish;
//    }
//
//    public String getPet() {
//        return pet;
//    }
//
//    public void setPet(String pet) {
//        this.pet = pet;
//    }
//
//    public String getImmediateNeeds() {
//        return immediateNeeds;
//    }
//
//    public void setImmediateNeeds(String immediateNeeds) {
//        this.immediateNeeds = immediateNeeds;
//    }
}
