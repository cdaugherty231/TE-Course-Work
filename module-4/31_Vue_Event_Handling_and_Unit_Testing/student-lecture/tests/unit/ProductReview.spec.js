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

  it("should be a Vue instance", () => {
    wrapper.isVueInstance().should.be.true;
  });

  describe('Method Tests', () => {

    it("should add a new review when addNewReview is called", () => {
      const testReview = {
        reviewer: "TEST NAME",
        title: "TEST TITLE",
        review: "TEST REVIEW",
        rating: 5
      };

      wrapper.setData({
        reviews: [],
        newReview: testReview
      });

      wrapper.vm.addNewReview();
      wrapper.vm.reviews[0].should.deep.equals(testReview);
    });

  });

  describe('Computed Property Tests', () => {
    const testReviews = [
      {
        reviewer: "TEST1",
        rating: 1
      },
      {
        reviewer: "TEST2",
        rating: 3
      },
      {
        reviewer: "TEST3",
        rating: 2
      },
      {
        reviewer: "TEST4",
        rating: 3
      },
      {
        reviewer: "TEST5",
        rating: 2
      },
      {
        reviewer: "TEST6",
        rating: 3
      },
      {
        reviewer: "TEST7",
        rating: 5
      },
      {
        reviewer: "TEST8",
        rating: 5
      }
    ];

    it("should return only count of one star reviews from numberOfOneStarReviews", () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfOneStarReviews.should.equal(1);
    });
    it("should return only count of two star reviews from numberOfTwoStarReviews", () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfTwoStarReviews.should.equal(2);
    });
    it("should return only count of three star reviews from numberOfThreeStarReviews", () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfThreeStarReviews.should.equal(3);
    });
    it("should return only count of four star reviews from numberOfFourStarReviews", () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfFourStarReviews.should.equal(0);
    });
    it("should return only count of five star reviews from numberOfFiveStarReviews", () => {
      wrapper.setData({ reviews: testReviews });
      wrapper.vm.numberOfFiveStarReviews.should.equal(2);
    });

  });
});
