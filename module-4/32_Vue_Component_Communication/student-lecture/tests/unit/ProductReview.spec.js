import ProductReview from '@/components/ProductReview.vue';
/* eslint-disable-next-line no-unused-vars */
import { shallowMount, Wrapper } from '@vue/test-utils';

import chai from 'chai';
chai.should();

describe('ProductReview', () => {
  /** @type Wrapper */
  let wrapper;
  beforeEach( () => {
    wrapper = shallowMount(ProductReview);
  });

  it('should be a Vue instance', () => {
    wrapper.isVueInstance().should.be.true;
  });

  describe('Method Tests', () => {
    it('should add a new review when addNewReview is called', () => {
      const testReview = {
        reviewer: 'TEST NAME',
        title: 'TEST TITLE',
        review: 'TEST REVIEW',
        rating: 5
      };

      wrapper.setData({
        reviews: [],
        newReview: testReview
      });

      wrapper.vm.addNewReview();
      wrapper.vm.reviews[0].should.deep.equals(testReview);
    });

    it('should clear the form and close the form when resetForm is called', () => {
      wrapper.setData({
        newReview: { reviewer: 'TEST' },
        showForm: true
      });

      wrapper.vm.resetForm();

      wrapper.vm.newReview.should.deep.equal({});
      wrapper.vm.showForm.should.be.false;
    });

    it('should return a proper count of reviews', () => {
      const testReviews = [
        {
          reviewer: 'TEST1',
          rating: 1
        },
        {
          reviewer: 'TEST2',
          rating: 3
        },
        {
          reviewer: 'TEST3',
          rating: 2
        },
        {
          reviewer: 'TEST4',
          rating: 3
        }
      ];

      wrapper.vm.numberOfReviews(testReviews, 3).should.equal(2);
      wrapper.vm.numberOfReviews(testReviews, 1).should.equal(1);
      wrapper.vm.numberOfReviews(testReviews, 5).should.equal(0);
    });

    it('should return 0 when there are no reviews', () => {
      wrapper.vm.numberOfReviews([], 1).should.equal(0);
      wrapper.vm.numberOfReviews([], 5).should.equal(0);
    });
  });

  describe('Computed Property Tests', () => {
    const testReviews = [
      {
        reviewer: 'TEST1',
        rating: 1
      },
      {
        reviewer: 'TEST2',
        rating: 3
      },
      {
        reviewer: 'TEST3',
        rating: 2
      },
      {
        reviewer: 'TEST4',
        rating: 3
      },
      {
        reviewer: 'TEST5',
        rating: 2
      },
      {
        reviewer: 'TEST6',
        rating: 3
      },
      {
        reviewer: 'TEST7',
        rating: 5
      },
      {
        reviewer: 'TEST8',
        rating: 5
      }
    ];

    // Lecture code to walk through
    it('should return only count of one star reviews from numberOfOneStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfOneStarReviews.should.equal(1);
    });
    it('should return only count of two star reviews from numberOfTwoStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfTwoStarReviews.should.equal(2);
    });
    it('should return only count of three star reviews from numberOfThreeStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfThreeStarReviews.should.equal(3);
    });
    it('should return only count of four star reviews from numberOfFourStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfFourStarReviews.should.equal(0);
    });
    it('should return only count of five star reviews from numberOfFiveStarReviews', () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfFiveStarReviews.should.equal(2);
    });

    it('should have only filtered reviews in filteredReviews', () => {
      wrapper.setData({ reviews: testReviews, filter: 2 });
      wrapper.vm.filteredReviews.length.should.equal(2);
      wrapper.vm.filteredReviews[0].reviewer.should.equal('TEST3');
      wrapper.vm.filteredReviews[1].reviewer.should.equal('TEST5');
    });

    it('should have all reviews in filteredReviews when filter is zero', () => {
      wrapper.setData({ reviews: testReviews, filter: 0 });
      wrapper.vm.filteredReviews.length.should.equal(8);
    });

    it('should have average review total in averageRating', () => {
      wrapper.setData({
        reviews: [
          {
            reviewer: 'TEST1',
            rating: 1
          },
          {
            reviewer: 'TEST2',
            rating: 5
          }
        ]
      });

      wrapper.vm.averageRating.should.equal(3);
    });

    it('should have zero for averageRating if no reviews', () => {
      wrapper.setData({ reviews: [] });
      wrapper.vm.averageRating.should.equal(0);
    });
  });
});
