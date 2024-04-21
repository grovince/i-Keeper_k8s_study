# AWS 3-Tier 환경 및 CI/CD 파이프라인 구축
</br>

### 프로젝트 소개
#### 🍀프로젝트명
* AWS 3-Tier 환경 및 CI/CD 파이프라인 구축
</br>

#### 🍀프로젝트 소개
* Web-WAS-DB로 구성된 3-Tier 환경 구축
* AWS EKS를 중점으로 클러스터 환경 구축
* CI/CD 파이프라인으로 구성된 자동화 배포
</br>

#### 🍀주요 사용 기술
- AWS EKS (AWS Elastic Kubernetes Service)
- AWS Load Balancer
- AWS RDS
- GitHub Action
- ArgoCD
</br>

---

</br>

### 프로젝트 내용
#### 🍀주요 핵심 기술
1. **Kubernetes Service**
    - SVC, Deployment, Statefulset, ConfigMap, Secret, PV/PVC
2. **AWS Cloud Service**
    - Route 53 - 도메인 관리
    - Ingress Controller - 부하분산
    - RDS - 데이터 관리
    - ECR (Elastic Container Registry) - 이미지 저장소
    - EKS (Elastic Kubernetes Service) - 컨테이너 오케스트레이션
    - ACM (AWS Certificate Manager) - HTTPS 통신 인증서 발급 (보안)
3. **CI/CD**
    - Gtihub Action
    - ArgoCD
      
</br>

###### GitHub Action 사용 이유
    * Code repository로 Github를 사용하였기 때문에 관리의 편의성을 위해 사용하였습니다.
    * 익숙한 환경인 컨테이너(도커)를 기반으로 동작하기 때문에 사용하였습니다.
###### ArgoCD 사용 이유
    * 해당 프로젝트는 Kubernetes를 기반으로 환경을 구축하였기 때문에 Kubernetes 전용 애플리케이션 자동 배포 툴인 ArgoCD를 사용하였습니다. 

</br>

#### 🍀프로젝트 간단 소개   
* Kubernetes를 기반으로 Web-WAS-DB로 구성된 3-Tier 웹 애플리케이션 환경을 AWS Cloud Service로 구성하였고, 배포의 효율성과 편리성을 높이기 위해 Github Action, ArgoCD를 사용하여 CI/CD 파이프라인을 구축하였습니다. 접근과 관리의 편의성을 위해 AWS Route 53, Ingress Controller, ACM, ECR 서비스를 사용하였고, AWS EKS 서비스를 통해 컨테이너 오케스트레이션을 완전관리형으로 구현하였습니다.

</br>

#### 🍀3-Tier 상세 구성도 및 설정
###### 📌Frontend

###### 📌Backend

###### 📌Database

###### 📌CI/CD Pipeline
